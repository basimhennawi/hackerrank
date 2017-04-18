class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        if (a.score == b.score) {
            if (a.name.compareTo(b.name) < 0) {
                return -1;
            }
            else if (a.name.compareTo(b.name) > 0) {
                return 1;
            }
            return 0;
        } else if (a.score > b.score) {
            return -1;
        } else if (a.score < b.score) {
            return 1;
        }
        return 0;
    }
}
