import java.util.Scanner;

// Creating a class Node to store Friend IDs
class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}


// Creating a class Node to store User details
class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendHead;  
    UserNode next;           

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendHead = null;
        this.next = null;
    }
}

class SocialMediaList {
    private UserNode head;
    
    // Creating a method to add a new user
    public void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Creating a method to search user by ID
    private UserNode searchById(int id) {
        UserNode temp = head;
        while(temp != null) {
            if(temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Creating a method to search user by Name
    public void searchByName(String name) {
        UserNode temp = head;
        boolean found = false;

        while(temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                displayUser(temp);
                found = true;
            }
            temp = temp.next;
        }

        if(!found)
            System.out.println("User not found");
    }

    // Creating a method to add friend connection (bidirectional)
    public void addFriend(int id1, int id2) {
        UserNode u1 = searchById(id1);
        UserNode u2 = searchById(id2);

        if(u1 == null || u2 == null) {
            System.out.println("One or both users not found");
            return;
        }

        addFriendToList(u1, id2);
        addFriendToList(u2, id1);
        System.out.println("Friend connection added");
    }

    // Creating a helper method to add friend ID to friend list
    private void addFriendToList(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friendHead;
        user.friendHead = newFriend;
    }

    // Creating a method to remove friend connection (bidirectional)
    public void removeFriend(int id1, int id2) {
        UserNode u1 = searchById(id1);
        UserNode u2 = searchById(id2);

        if(u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        removeFriendFromList(u1, id2);
        removeFriendFromList(u2, id1);
        System.out.println("Friend connection removed");
    }

    // Creating a helper method to remove friend ID
    private void removeFriendFromList(UserNode user, int friendId) {
        FriendNode temp = user.friendHead;

        if(temp != null && temp.friendId == friendId) {
            user.friendHead = temp.next;
            return;
        }

        while(temp != null && temp.next != null) {
            if(temp.next.friendId == friendId) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    // Creating a method to display all friends of a user
    public void displayFriends(int userId) {
        UserNode user = searchById(userId);
        if(user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Friends of " + user.name + ": ");
        FriendNode temp = user.friendHead;

        if(temp == null) {
            System.out.println("No friends");
            return;
        }

        while(temp != null) {
            UserNode friendUser = searchById(temp.friendId);
            if(friendUser != null) {
                System.out.println("ID: " + friendUser.userId + ", Name: " + friendUser.name);
            }
            temp = temp.next;
        }
    }

    // Creating a method to find mutual friends between two users
    public void findMutualFriends(int id1, int id2) {
        UserNode u1 = searchById(id1);
        UserNode u2 = searchById(id2);

        if(u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Mutual Friends: ");
        FriendNode f1 = u1.friendHead;
        boolean found = false;

        while(f1 != null) {
            FriendNode f2 = u2.friendHead;
            while(f2 != null) {
                if(f1.friendId == f2.friendId) {
                    System.out.print(f1.friendId + " ");
                    found = true;
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }

        if(!found) {
            System.out.print("None");
        }

        System.out.println();
    }

    // Creating a method to count number of friends for each user
    public void countFriends() {
        UserNode temp = head;

        while(temp != null) {
            int count = 0;
            FriendNode f = temp.friendHead;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friends");
            temp = temp.next;
        }
    }

    // Creating a method to display the user
    private void displayUser(UserNode u) {
        System.out.println("ID: " + u.userId + ", Name: " + u.name + ", Age: " + u.age);
    }
}

/*
 Main Class
*/
public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating an object of the class 
        SocialMediaList sm = new SocialMediaList();
        int choice;

        do {
            System.out.println("\n1.Add User");
            System.out.println("2.Add Friend");
            System.out.println("3.Remove Friend");
            System.out.println("4.Display Friends");
            System.out.println("5.Mutual Friends");
            System.out.println("6.Search by Name");
            System.out.println("7.Count Friends");
            System.out.println("8.Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sm.addUser(id, name, age);

                    System.out.println("User added successfully");
                    break;

                case 2:
                    System.out.print("User1 ID: ");
                    int user1 = sc.nextInt();
                    System.out.print("User2 ID: ");
                    int user2 = sc.nextInt();
                    sm.addFriend(user1, user2);

                    break;

                case 3:
                    System.out.print("User1 ID: ");
                    int r1 = sc.nextInt();
                    System.out.print("User2 ID: ");
                    int r2 = sc.nextInt();
                    sm.removeFriend(r1, r2);

                    break;

                case 4:
                    System.out.print("User ID: ");
                    sm.displayFriends(sc.nextInt());
                    break;

                case 5:
                    System.out.print("User1 ID: ");
                    int m1 = sc.nextInt();
                    System.out.print("User2 ID: ");
                    int m2 = sc.nextInt();
                    sm.findMutualFriends(m1, m2);
                    break;

                case 6:
                    sc.nextLine();
                    System.out.print("Name: ");
                    sm.searchByName(sc.nextLine());
                    break;

                case 7:
                    sm.countFriends();
                    break;

                case 8:
                    System.out.println("Exited");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 8);

        sc.close();
    }
}

