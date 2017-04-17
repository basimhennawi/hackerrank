static boolean isAnagram(String a, String b) {
    if (a.length() != b.length()) {
        return false;
    }

    char[] charA = a.toLowerCase().toCharArray();
    char[] charB = b.toLowerCase().toCharArray();

    Arrays.sort(charA);
    Arrays.sort(charB);

    return new String(charA).equals(new String(charB)) ? true : false;
}
