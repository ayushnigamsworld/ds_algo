package codility;

public class JohnLikesToTravel {
}

//// you can also use imports, for example: import java.util.*; import java.util.Date; import java.text.*; // you can write to stdout for debugging purposes, e.g. // System.out.println("this is a debug message"); class Solution { List<Photo> storage = new ArrayList<>(); List<Photo> original = new ArrayList<>(); public String solution(String input) { // write your code in Java SE 8 String result = ""; String[] lineInputArr = input.split("\n"); for (int i = 0; i<lineInputArr.length; i++) { String currentLine = lineInputArr[i]; String[] itemArr = currentLine.split(","); for (int j=0; j<3; j++) { String name = itemArr[0].trim(); // String extension = name.substring(name.length()-3); String location = itemArr[1].trim(); String dateTime = itemArr[2].trim(); //System.out.println("Ext: "+ extension + " lo "+ location + " - "+ dateTime); process(name, location, dateTime); } } Collections.sort(storage); List<Photo> resultList = new ArrayList<>(); for (Photo p: storage) { resultList.add(p); } for (Photo current : original) { String name = current.extension; } //  System.out.println(storage); for (Photo p: resultList) { String ext = p.extension.substring(p.extension.length()-3); result += p.location + "." + ext; result += "\n"; } return result; } private void process(String extension, String location, String date) { SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); try { Date d = f.parse(date); // System.out.println(d); Photo p = new Photo(extension, location, d); storage.add(p); original.add(p); } catch(Exception e) { } } } class Photo implements Comparable { String extension; String location; Date date; public Photo(String extension, String location, Date date) { this.extension = extension; this.location = location; this.date = date; } @Override public int compareTo(Object p) { return this.date.compareTo(((Photo)p).date); } @Override public String toString() { return this.location + this.date; } }