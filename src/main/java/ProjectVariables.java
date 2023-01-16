public class ProjectVariables {
private static String userID;
private static String organizationID;
private static String boardID;
private static String listID;

    public static String getUserID() {
        return userID;
    }

    public static String getOrganizationID() {
        return organizationID;
    }

    public static String getBoardID() {
        return boardID;
    }

    public String getListID() {
        return listID;
    }

    public void setUserID(String user1ID) {
        userID = user1ID;
    }

    public  static void setOrganizationID(String orgID) {
        organizationID = orgID;
    }

    public static void setBoardID(String boardId) {
        boardID = boardId;
    }

    public static void setListID(String listId) {
        listID = listId;
    }
}
