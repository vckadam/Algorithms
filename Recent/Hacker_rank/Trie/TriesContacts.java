/*
Tries: Contacts

We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.

Input Format

The first line contains a single integer, , denoting the number of operations to perform. 
Each line  of the  subsequent lines contains an operation in one of the two forms defined above.

Constraints

It is guaranteed that  and  contain lowercase English letters only.
The input doesn't have any duplicate  for the  operation.
Output Format

For each find partial operation, print the number of contact names starting with  on a new line.

Sample Input

4
add hack
add hackerrank
find hac
find hak
Sample Output

2
0
Explanation

We perform the following sequence of operations:

Add a contact named hack.
Add a contact named hackerrank.
Find and print the number of contact names beginning with hac. There are currently two contact names in the application and both of them start with hac, so we print  on a new line.
Find and print the number of contact names beginning with hak. There are currently two contact names in the application but neither of them start with hak, so we print  on a new line.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class Node {
        Node[] nodes;
        int count;
        public Node() {
            nodes = new Node[26];
            count = 0;
        }
    }
    static class Trie {
        Node root;
        public Trie() {
            root = new Node();
        }
        
        public void add(String str) {
            Node temp = root;
            for(int i = 0; i < str.length(); i++) {
                if(temp.nodes[str.charAt(i)-'a'] == null) temp.nodes[str.charAt(i)-'a'] = new Node();
                temp = temp.nodes[str.charAt(i)-'a'];
                temp.count++;
            }
        }
        
        public int find(String str) {
            Node temp = root;
            for(int i = 0; i < str.length(); i++) {
                if(temp.nodes[str.charAt(i)-'a'] == null) return 0;
                temp = temp.nodes[str.charAt(i)-'a'];
            }
            return temp.count;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie trie = new Trie();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")) {
                trie.add(contact);
            } else {
                System.out.println(trie.find(contact));
            }
        }
    }
}
