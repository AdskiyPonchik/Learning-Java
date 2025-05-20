package aud.queue;

public class JosephusProblem {

    // Solve the Josephus problem for a list of persons and a number k
    // of persons to be skipped. The solution should "simulate" the
    // counting-out and return a queue that contains all persons in the
    // order they were counted out.
    //
    public static Queue<String> solve(String[] persons, int k) {
        Queue<String> queue = new Queue<>();
        Queue<String> result = new Queue<>();
        int size = persons.length;
        for (String person : persons) {
            queue.enqueue(person);
        }
        while (!queue.is_empty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            result.enqueue(queue.dequeue());
        }
        return result;
    }


    public static void main(String[] args) {
         String[] deutscheNamen = {"Jan","Jil","Ulf", "Kai", "Mark"};
         System.out.println(JosephusProblem.solve(deutscheNamen, 5));
         /**
         String[] deutscheNamen = {
         "Lukas",
         "Sophia",
         "Leon",
         "Emma",
         "Finn",
         "Hannah",
         "Maximilian",
         "Mia",
         "Paul",
         "Lina",
         "Jonas",
         "Anna",
         "Felix"
         };
         System.out.println(JosephusProblem.solve(deutscheNamen, 13));
         }
         */
    }
};
