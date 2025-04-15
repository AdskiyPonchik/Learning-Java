package Filter;
import java.util.function.Predicate;
// This class "wraps" an instance of `SList<Integer>` (attribute
// `li`): Calls to `toString()` and `push_front()` are "delegated" to
// the instance.
// The additional method `filter()` applies a predicate and constructs
// a new list with all items for which the predicate evaluates to `true`.
//
public class IntSList {
  // Store list of integers as an SList.
  SList<Integer> li;

  public IntSList() {
    // TODO: Constructor
    li = new SList<>();
  }

  // delegate to SList
  @Override
  public String toString() {
    return li.toString();
  }

  // delegate to SList
  public void push_front(int obj){
    li.push_front(obj);
  }
  public void push_back(int obj){li.push_back(obj);}

  // Filter list by predicate `p` and return list of all items for
  // which predicate evaluates to `true`.
  // The order of items in the returned list may differ from the order
  // in `this` list (because we use always `push_front()`).
  //
  public IntSList filter(Predicate<Integer> p){
    IntSList newlist = new IntSList();
    for(Integer val: li){
        if(p.test(val)){newlist.push_back(val);}
    }
    return newlist;
  }

  // You must provide a main() method!
  public static void main(String args[]) {
    // TODO: test
    IntSList list = new IntSList();
    list.push_front(85);
    list.push_front(93);
    list.push_front(72);
    list.push_front(81);
    list.push_front(74);
    list.push_front(42);
    System.out.println(list.filter(x->x>42).toString());
    System.out.print(list.filter(x->x%2==0).toString());
  }
}
