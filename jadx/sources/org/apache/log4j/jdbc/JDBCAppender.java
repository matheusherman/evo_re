package org.apache.log4j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class JDBCAppender extends AppenderSkeleton implements Appender {
    protected String databaseURL = "jdbc:odbc:myDB";
    protected String databaseUser = "me";
    protected String databasePassword = "mypassword";
    protected Connection connection = null;
    protected String sqlStatement = "";
    protected int bufferSize = 1;
    private boolean locationInfo = false;
    protected ArrayList buffer = new ArrayList(this.bufferSize);
    protected ArrayList removes = new ArrayList(this.bufferSize);

    protected void execute(String str) throws Throwable {
        Connection connection;
        Statement statementCreateStatement = null;
        try {
            connection = getConnection();
            try {
                statementCreateStatement = connection.createStatement();
                statementCreateStatement.executeUpdate(str);
                statementCreateStatement.close();
                closeConnection(connection);
            } catch (Throwable th) {
                th = th;
                if (statementCreateStatement != null) {
                    statementCreateStatement.close();
                }
                closeConnection(connection);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            connection = null;
        }
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return true;
    }

    public void flushBuffer() {
        this.removes.ensureCapacity(this.buffer.size());
        for (LoggingEvent loggingEvent : this.buffer) {
            try {
                try {
                    execute(getLogStatement(loggingEvent));
                } catch (SQLException e10) {
                    this.errorHandler.error("Failed to excute sql", e10, 2);
                }
                this.removes.add(loggingEvent);
            } catch (Throwable th) {
                this.removes.add(loggingEvent);
                throw th;
            }
        }
        this.buffer.removeAll(this.removes);
        this.removes.clear();
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public boolean getLocationInfo() {
        return this.locationInfo;
    }

    public String getPassword() {
        return this.databasePassword;
    }

    public String getSql() {
        return this.sqlStatement;
    }

    public String getURL() {
        return this.databaseURL;
    }

    public String getUser() {
        return this.databaseUser;
    }

    public void setBufferSize(int i10) {
        this.bufferSize = i10;
        this.buffer.ensureCapacity(i10);
        this.removes.ensureCapacity(this.bufferSize);
    }

    public void setLocationInfo(boolean z10) {
        this.locationInfo = z10;
    }

    public void setPassword(String str) {
        this.databasePassword = str;
    }

    public void setSql(String str) {
        this.sqlStatement = str;
        if (getLayout() == null) {
            setLayout(new PatternLayout(str));
        } else {
            ((PatternLayout) getLayout()).setConversionPattern(str);
        }
    }

    public void setURL(String str) {
        this.databaseURL = str;
    }

    public void setUser(String str) {
        this.databaseUser = str;
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        loggingEvent.getNDC();
        loggingEvent.getThreadName();
        loggingEvent.getMDCCopy();
        if (this.locationInfo) {
            loggingEvent.getLocationInformation();
        }
        loggingEvent.getRenderedMessage();
        loggingEvent.getThrowableStrRep();
        this.buffer.add(loggingEvent);
        if (this.buffer.size() >= this.bufferSize) {
            flushBuffer();
        }
    }

    @Override // org.apache.log4j.Appender
    public void close() {
        flushBuffer();
        try {
            Connection connection = this.connection;
            if (connection != null && !connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e10) {
            this.errorHandler.error("Error closing connection", e10, 0);
        }
        this.closed = true;
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void finalize() {
        close();
    }

    protected Connection getConnection() {
        if (!DriverManager.getDrivers().hasMoreElements()) {
            setDriver("sun.jdbc.odbc.JdbcOdbcDriver");
        }
        if (this.connection == null) {
            this.connection = DriverManager.getConnection(this.databaseURL, this.databaseUser, this.databasePassword);
        }
        return this.connection;
    }

    protected String getLogStatement(LoggingEvent loggingEvent) {
        return getLayout().format(loggingEvent);
    }

    public void setDriver(String str) {
        try {
            Class.forName(str);
        } catch (Exception e10) {
            this.errorHandler.error("Failed to load driver", e10, 0);
        }
    }

    protected void closeConnection(Connection connection) {
    }
}
