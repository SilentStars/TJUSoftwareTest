package cn.tjusic.st.Lab1;
import java.util.ArrayList;

public class TriangleProblem {
    Boolean findSolution(int account) {
        ArrayList<Integer> array = new ArrayList<Integer>();

        array.add(0, 50);
        array.add(1,20);
        array.add(2,5);
        array.add(3,5);
        array.add(4,1);
        array.add(5,1);
        array.add(6,1);

        for(int i = 0; i < array.size(); i++) {
            if(account >= array.get(i)) {
                account -= array.get(i);
            }
            if(account < 0 || account == 0) {
                break;
            }
        }

        if (account != 0) {
            return false;
        } else {
            return true;
        }
    }
}
