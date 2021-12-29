class MyStack {
Queue<Integer> q;
    public MyStack() {
        q= new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        int k=0;
       Iterator itr = q.iterator();
        while(itr.hasNext()){
          k=(int)itr.next();
                  if(itr.hasNext()==false){
                  itr.remove();
                    
           break; }
           
        }
       
        return k;
    }
    
    public int top() {
        int k=0;
         Iterator itr = q.iterator();
        while(itr.hasNext()){
             k=(int)itr.next();
            }
        return k;
    }
    
    public boolean empty() {
        if(q.size()>0)
            return false;
        return true;
    }
}