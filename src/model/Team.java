package model;

import java.util.LinkedList;

public class Team {
    LinkedList<Player> members;

    public Team(LinkedList<Player> newMembers) {
        this.members = newMembers;
    }

    public boolean isMember(Player player) {
        return this.members.contains( player );
    }

    public Player getMember(int i){
        return  (this.members.get(i));
    }

    public Player pollFirst(){
        return this.members.pollFirst();
    }

    public void addLast(Player newLastPlayer) {
        this.members.addLast(newLastPlayer);
    }
}
