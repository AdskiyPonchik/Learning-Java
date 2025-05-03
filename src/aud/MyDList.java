package aud;

public class MyDList<T> extends DList<T> {
    //-----------------------------------------------------------------//
    public MyDList() {
        super();
    }

    //-----------------------------------------------------------------//
//    private void append_universal(MyDList<T> unilist) {
//        DList<T>.Node current_node = unilist.head_;
//        while (current_node != null) {
//            this.push_back(current_node.data_);
//            current_node = current_node.next_;
//        }
//    }
//
//    public void append(MyDList<T> li) {
//        if (this == li) {
//            MyDList<T> temp_list = new MyDList<>();
//            temp_list.append_universal(li);
//            this.append_universal(temp_list);
//        } else {
//            this.append_universal(li);
//        }
//    }

    private void append_universal(MyDList<T> unilist) {
        ForwardIterator it = unilist.iterator();
        while (it.hasNext()) {
            this.push_back(it.next());
        }
    }

    public void append(MyDList<T> li) {
        if (this == li) {
            MyDList<T> temp_list = new MyDList<>();
            temp_list.append_universal(li);
            this.append_universal(temp_list);
        } else {
            this.append_universal(li);
        }
    }

    //-----------------------------------------------------------------//
    public void insert(int n, MyDList<T> li) {
        int size = this.size();
        ForwardIterator current_node = this.iterator();

        if (n < 0 || n > size) {
            throw new IndexOutOfBoundsException("There is some problem with index");
        }
        if (n == size) {
            append(li);
            return;
        }
        for (int i = 0; i < n; i++) {
            current_node.next();
        }

        MyDList<T> tempList = new MyDList<>();
        ForwardIterator liIt = li.iterator();
        while (liIt.hasNext()) {
            tempList.push_back(liIt.next());
        }

        ForwardIterator it = tempList.iterator();
        while (it.hasNext()) {
            insert_before(current_node, it.next());
        }
    }


    //-----------------------------------------------------------------//
    public static void main(String[] args) {

    }
}