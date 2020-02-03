public void query() {
    long startTime = System.currentTimeMillis();

    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    } catch (ClassNotFoundException e1) {
        e1.printStackTrace();
    }

    String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=master;user=sa;password=abcABC123";

    try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
        String SQL = "SELECT TOP 10 * FROM dbo.spt_monitor";
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            System.out.print(rs.getString("cpu_busy"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    long endTime = System.currentTimeMillis();
    System.out.println(" That took " + (endTime - startTime) + " milliseconds");
}
}