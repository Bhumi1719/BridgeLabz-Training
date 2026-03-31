interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        // Password rules:
        // 1. Minimum 8 characters
        // 2. At least one uppercase letter
        // 3. At least one lowercase letter
        // 4. At least one digit
        // 5. At least one special character (!@#$%^&*)
        
        if(password.length() < 8) {
            return false;
        }

        if(!password.matches(".*[A-Z].*")) {
            return false;
        }

        if(!password.matches(".*[a-z].*")) {
            return false;
        }

        if(!password.matches(".*\\d.*")) {
            return false;
        }

        if(!password.matches(".*[!@#$%^&*].*")) {
            return false;
        }
        
        return true;
    }
}
