public class ll{
    
    public static class linkedlist{
        public class Node{
            int data = 0;
            Node next = null;

            public Node(int data){
                this.data = data;
            }
        }

        Node head = null;
        Node tail = null;
        int size = 0;

        //========= general util ====================

        public int size(){
            return this.size;
        }

        public boolean isEmpty(){
            return (this.size()==0);
        }

        @Override
        public String toString(){
            Node curr = this.head;
            String str = " ";
            while(curr!=null){
                str+=curr.data+" ";
                curr = curr.next;
            }
            return str;
            // return ("hi");
        }

        public Node getNodeAt(int pos){
            Node curr = this.head;
            while(pos>0){
                curr = curr.next;
                pos--;
            }
            return curr;
        }

        // add function

        private void addFirstNode(Node node){
            if(this.size==0){
                this.tail=node;
                this.head=node;
            }else{
                node.next=this.head;
                this.head=node;
            }
            this.size++;
        }

        public void addFirst(int data){
            Node node = new Node(data);
            addFirstNode(node);
        }

        private void addLastNode(Node node){
            if(this.size==0){
                this.tail=node;
                this.head=node;
            }else{
                tail.next = node;
                this.tail = node;
            }
            this.size++;
        }

        public void addLast(int data){
            Node node = new Node(data);
            addLastNode(node);
        }

        private void addAtNode(Node node, int pos){
            if(pos==0){
                addFirstNode(node);
            }
            if(pos == this.size){
                addLastNode(node);
            }

            Node prevnode = getNodeAt(pos-1);
            Node tempnode = prevnode.next;

            prevnode.next = node;
            node.next = tempnode;

            this.size++;    
        }
        public void addAt(int data, int pos){
            if(pos<0 || pos>this.size){
                System.out.print("nullpoint exception");
            }
            Node node = new Node(data);
            addAtNode(node, pos);
        }
        

        // remove function

        public int removeFirst(){
            if(this.size==0){
                System.out.print("Empty List");
                return -1;
            }
            
            Node rnode = this.head;

            if(this.size==1){
                this.head = null;
                this.tail = null;
            }else{
                this.head = this.head.next;
                rnode.next = null;
            }

            this.size--;
            return rnode.data;
        }

        public int removeLast(){
            if(this.size==0){
                System.out.println("EmptyList!");
                return -1;
            }

            Node rnode=this.tail;
            if(this.size==1){
                this.head=null;
                this.tail=null;
            }else{
                Node secondLastNode=getNodeAt(this.size()-2);
                secondLastNode.next=null;
                this.tail=secondLastNode;
            }

            this.size--;
            return rnode.data;
        }
        
        public int removeAt(int pos){
            if(pos<0 || pos >= this.size){
                System.out.print("nullpoint exception");
                return -1;
            } 

            if(pos==0)
                removeFirst();
            else if(pos==this.size-1)
                removeLast();
            
            else{
                Node prev=getNodeAt(pos-1);
                Node next=prev.next;

                prev.next=next.next;
                next.next=null;
                this.size--;

                return next.data;
            }
        }

        // get function
    }

    public static void main(String[] args){
        linkedlist ll = new linkedlist();
        for(int i=1;i<=10;i++){
            ll.addFirst(i);
        } 
        // for(int i=1;i<=10;i++){
        //     ll.addLast(i*10);
        // }
        // ll.removeFirst();
        // ll.removeLast();
        ll.removeAt(4);
        System.out.print(ll);
    }
}



