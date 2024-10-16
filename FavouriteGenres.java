public class Main {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {

        Map<String, List<String>> res = new HashMap<>();

        Map<String, String> songstogenre = new HashMap<>();

        for(String genre : genreMap.keySet()) {

            List<String> songs = genreMap.get(genre);

            for(String song : songs) {

                songstogenre.put(song, genre);

            }

        }

        Map<String, Integer> count ;

        int max = 0;

        for(String user : userMap.keySet()) {

            count = new HashMap();

            max = 0;

            res.put(user, new ArrayList());

            List<String> songs = userMap.get(user);

            for(String song : songs) {

                String genre = songstogenre.get(song);

                int c = count.getOrDefault(genre, 0) + 1;

                count.put(genre, c);

                max = Math.max(c, max);

            }

            System.out.println(count);

            for (String key : count.keySet()) {

                if (count.get(key) == max) {

                    res.get(user).add(key);

                }

            }

        }

        return res;

    }

    public static void main(String[] args) {

        HashMap<String, List<String>> userSongs = new HashMap<>();

        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));

        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

        HashMap<String, List<String>> songGenres = new HashMap<>();

        songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));

        songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));

        songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));

        songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));

        songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

        System.out.println(res);

    }

}