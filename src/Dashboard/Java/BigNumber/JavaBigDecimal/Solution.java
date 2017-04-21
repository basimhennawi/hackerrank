String temp;
for (int i = 1; i < n; i++) {
    for (int j = i ; j > 0; j--) {
        if (new BigDecimal(s[j]).compareTo(new BigDecimal(s[j-1])) > 0) {
            temp = s[j];
            s[j] = s[j-1];
            s[j-1] = temp;
        }
    }
}
