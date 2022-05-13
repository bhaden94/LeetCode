class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        boolean carry = false;
        int aPtr = a.length() - 1, bPtr =  b.length() - 1;
        
        while (aPtr >= 0 && bPtr >= 0) {
            if (a.charAt(aPtr) == '1' && b.charAt(bPtr) == '1') {
                if (carry) {
                    res.insert(0, "1");
                } else {
                    res.insert(0, "0");
                    carry = true;
                }
            } else if ((a.charAt(aPtr) == '1' && b.charAt(bPtr) == '0') ||
                      (a.charAt(aPtr) == '0' && b.charAt(bPtr) == '1')) {
                if (carry) {
                    res.insert(0, "0");
                } else {
                    res.insert(0, "1");
                }
            } else {
                if (carry) {
                    res.insert(0, "1");
                    carry = false;
                } else {
                    res.insert(0, "0");
                }
            }
            aPtr--;
            bPtr--;
        }
        
        while (aPtr >= 0 || bPtr >= 0) {
            if (aPtr >= 0) {
                if (a.charAt(aPtr) == '1') {
                    if (carry) {
                        res.insert(0, "0");
                    } else {
                        res.insert(0, "1");
                    }
                } else {
                    if (carry) {
                        res.insert(0, "1");
                        carry = false;
                    } else {
                        res.insert(0, "0");
                    }
                }
                aPtr--;
            } else {
                if (b.charAt(bPtr) == '1') {
                    if (carry) {
                        res.insert(0, "0");
                    } else {
                        res.insert(0, "1");
                    }
                } else {
                    if (carry) {
                        res.insert(0, "1");
                        carry = false;
                    } else {
                        res.insert(0, "0");
                    }
                }
                bPtr--;
            }
        }
        
        if (carry) res.insert(0, "1");
        return res.toString();
    }
}
