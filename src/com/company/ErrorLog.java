package com.company;

public class ErrorLog {

    private String machineId;
    private String description;

    /**
     * Precondition: message is a valid Error log entry
     */
    public ErrorLog(String message) {
        int x = message.indexOf(":") + 1;
        machineId = message.substring(0, x);
        description = message.substring(x);
    }

    /**
     * Returns true if the description in this error log entry
     * contains keyword; false otherwise.
     */
    public boolean containsKey(String keyword) {
        int x = 0;
        int y = 0;
        String compare = " " + keyword + " ";
        boolean r = false;
        for (int i = 0; i <= description.length(); i++) {
            x = description.indexOf(" ", i);
            y = compare.length() + 1;
            String d = description.substring(x, y);
            if (d == compare) {
                r = true;
                break;
            }

            //for (int j=1; j<=compare.length(); j++){}
        }

        return r;
    }

    public String getMachineId() {
        return machineId;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        ErrorLog er1 = new ErrorLog("CLIENT2:security alert");
        ErrorLog er2 = new ErrorLog("Webserver:disk offline");
        ErrorLog er3 = new ErrorLog("SERVER22:file not found on disk3");
        ErrorLog er4 = new ErrorLog("SERVER15:read error on disk DSK7");
        ErrorLog er5 = new ErrorLog("SERVER22:write error on disk");
        ErrorLog er6 = new ErrorLog("Webserver:error on /dev/disk");

        System.out.println("message 1 " + er1.containsKey("disk"));
        System.out.println("message 2 " + er2.containsKey("disk"));
        System.out.println("message 3 " + er3.containsKey("disk"));
        System.out.println("message 4 " + er4.containsKey("disk"));
        System.out.println("message 5 " + er5.containsKey("disk"));
        System.out.println("message 6 " + er6.containsKey("disk"));
    }
}