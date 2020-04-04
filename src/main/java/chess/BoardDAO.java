package chess;

import java.sql.*;

public class BoardDAO {
    public Connection getConnection() {
        Connection con = null;
        String server = "localhost:13306"; // MySQL 서버 주소
        String database = "chess"; // MySQL DATABASE 이름
        String option = "?useSSL=false&serverTimezone=UTC";
        String userName = "root"; //  MySQL 서버 아이디
        String password = "root"; // MySQL 서버 비밀번호

        // 드라이버 로딩
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" !! JDBC Driver load 오류: " + e.getMessage());
            e.printStackTrace();
        }

        // 드라이버 연결
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + option, userName, password);
            System.out.println("정상적으로 연결되었습니다.");
        } catch (SQLException e) {
            System.err.println("연결 오류:" + e.getMessage());
            e.printStackTrace();
        }

        return con;
    }

    // 드라이버 연결해제
    public void closeConnection(Connection con) {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            System.err.println("con 오류:" + e.getMessage());
        }
    }

    public String getPieceSymbolByPositionSymbol(String positionSymbol) throws SQLException {
        String query = "SELECT * FROM chessboard WHERE position = ?";
        PreparedStatement pstmt = getConnection().prepareStatement(query);
        pstmt.setString(1, positionSymbol);
        ResultSet rs = pstmt.executeQuery();

        if (!rs.next()) return null;
        return rs.getString("piece");
    }

//    public void addUser(User user) throws SQLException {
//        String query = "INSERT INTO user VALUES (?, ?)";
//        PreparedStatement pstmt = getConnection().prepareStatement(query);
//        pstmt.setString(1, user.getUserId());
//        pstmt.setString(2, user.getName());
//        pstmt.executeUpdate();
//    }
//
//    public User findByUserId(String userId) throws SQLException {
//        String query = "SELECT * FROM user WHERE user_id = ?";
//        PreparedStatement pstmt = getConnection().prepareStatement(query);
//        pstmt.setString(1, userId);
//        ResultSet rs = pstmt.executeQuery();
//
//        if (!rs.next()) return null;
//
//        return new User(
//                rs.getString("user_id"),
//                rs.getString("name"));
//    }
//
//    public void updateUser(User user1, User user2) throws SQLException {
//
//    }
//
//    public void deleteByUserId(String userId) throws SQLException {
//        String query = "DELETE FROM user WHERE user_id = ?";
//        PreparedStatement pstmt = getConnection().prepareStatement(query);
//        pstmt.setString(1, userId);
//        pstmt.executeUpdate();
//    }

}
