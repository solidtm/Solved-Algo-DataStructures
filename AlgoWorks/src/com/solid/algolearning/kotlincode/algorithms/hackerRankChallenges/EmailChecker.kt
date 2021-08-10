package com.solid.algolearning.kotlincode.algorithms.hackerRankChallenges

fun main() {
    val string1 = arrayOf("test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com")
    val string2 = arrayOf("test.email+alex@leetcode.com", "test.email.leet+alex@code.com")
    val string3 = arrayOf("a@leetcode.com", "b@leetcode.com", "c@leetcode.com")

    println(numUniqueEmails(string1))
    println(numUniqueEmails(string2))
    println(numUniqueEmails(string3))
}

//    Every valid email consists of a local name and a domain name, separated by the '@' sign.
//    Besides lowercase letters, the email may contain one or more '.' or '+'.
//
//    For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
//    If you add periods '.' between some characters in the local name part of an email address,
//    mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.
//
//    For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
//    If you add a plus '+' in the local name, everything after the first plus sign will be ignored.
//    This allows certain emails to be filtered. Note that this rule does not apply to domain names.
//
//    For example, "m.y+name@email.com" will be forwarded to "my@email.com".
//    It is possible to use both of these rules at the same time.
//
//    Given an array of strings emails where we send one email to each email[i],
//    return the number of different addresses that actually receive mails.
//
//
//
//            Example 1:
//
//    Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
//    Output: 2
//    Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
//            Example 2:
//
//    Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
//    Output: 3
//
//
//    Constraints:
//
//            1 <= emails.length <= 100
//            1 <= emails[i].length <= 100
//    email[i] consist of lowercase English letters, '+', '.' and '@'.
//    Each emails[i] contains exactly one '@' character.
//    All local and domain names are non-empty.
//    Local names do not start with a '+' character.
//
//            Naive approach by me:
//    public static int numUniqueEmails(String[] emails) {
//        String emailRegex = "^[a-z0-9][.|+]@[a-z0-9]|[a-z0-9].[a-z0-9].com";
//        Pattern p = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
//        Matcher m;
//        Set<String> emailValues = new HashSet<>();
//
////        loop through the emails array
//        for(String email : emails){
//            m = p.matcher(email);
//            if(m.find()){       //if we fid a match
//                String newEmail = trimEmail(email);     //trim the email (ie check for . and + characters in the email and do the needful)
//                if (emailValues.contains(newEmail)){    //if the Set contains the email then we return else we add it to the Set and increment the emailReceivers
//                    continue;
//                }
//                emailValues.add(newEmail);
//            }
//        }
//
//        return emailValues.size();
//    }
//
//    private static String trimEmail(String email) {
//        List<String> newEmail = new ArrayList<>();
//        String[] splitEmail = email.split("");
//        StringBuilder sb = new StringBuilder();
//        int plusIndex = 0, atIndex = 0, dotIndex = 0;
//
//        for (String value : splitEmail) {
//            if (value.equals("+")) {
//                plusIndex++;
//                continue;
//            }
//            if (value.equals("@")) {
//                atIndex++;
//            }
//            if (value.equals(".") && atIndex > 0) {
//                newEmail.add(value);
//            }
//            if (!value.equals(".")) {
//                if (!(plusIndex > 0) && !(atIndex > 0)) {
//                    newEmail.add(value);
//                }
//                if (atIndex > 0) {
//                    newEmail.add(value);
//                }
//
//            }
//
//        }
//
//        splitEmail = newEmail.toArray(new String[0]);
//        for (String s : splitEmail){
//            sb.append(s);
//        }
//
//        return sb.toString();
//    }
//    Easy to read solution and best approach:
fun numUniqueEmails(emails: Array<String>): Int {
    val unique: MutableSet<String> = HashSet()
    for (s in emails) {
        val nameAndDomain = s.split("@".toRegex()).toTypedArray() // ["name", "domain.com"];
        val name = nameAndDomain[0].replace("\\.".toRegex(), "").replace("\\+.*".toRegex(), "") // remove all '.' in the name and everything after a '+'
        val str = StringBuilder()
        str.append(name)
        str.append("@")
        str.append(nameAndDomain[1])
        unique.add(str.toString())
        println(str)
    }
    return unique.size
}