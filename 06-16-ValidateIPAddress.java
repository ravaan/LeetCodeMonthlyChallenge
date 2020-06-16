class Solution {
    public String validIPAddress(String ip) {
        if (ip.contains(":")) return ipv6(ip);
        return ipv4(ip);
    }

    public String ipv4(String ip) {
        int count = 0;
        for (char x : ip.toCharArray()) {
            if (x == '.') count++;
            else if (!Character.isDigit(x)) return "Neither";
        }
        if (count != 3) return "Neither";
        String[] domains = ip.split("\\.");

        if (domains.length != 4) return "Neither";

        for (String domain : domains) {
            int len = domain.length();
            if (len == 0 || len > 3) return "Neither";
            if (len != 1 && domain.charAt(0) == '0') return "Neither";
            if (Integer.parseInt(domain) > 255) return "Neither";
        }
        return "IPv4";
    }

    public String ipv6(String ip) {
        int count = 0;
        for (char x : ip.toCharArray()) {
            if (x == ':') count++;
            else if (!Character.isLetterOrDigit(x)) return "Neither";
        }
        if (count != 7) return "Neither";

        String[] domains = ip.split(":");

        if (domains.length != 8) return "Neither";

        for (String domain : domains) {
            int len = domain.length();
            if (len == 0 || len > 4) return "Neither";
            try {
                long num = Long.parseLong(domain, 16);
                if (len > 4 && domain.charAt(0) == '0') return "Neither";
            } catch (NumberFormatException nfe) {
                return "Neither";
            }
        }
        return "IPv6";
    }
}