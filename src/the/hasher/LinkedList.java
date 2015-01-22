/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package the.hasher;

/**
 *
 * @author geraldblake
 */
public class LinkedList 
{
    protected ListNode head,current;
    private int count;
    // LinkedList constructor
    public LinkedList()
    {
        //creates empty list with no data
        head = new ListNode(null);
        current = head;
        count = 0; 
    }
    protected ListNode head()
    {
        return head;
    }
    public boolean find(String key)
    {
        return find(key,head);
    }
    private boolean find(String key,ListNode node)
    {
        if(node.next() == null) // not found
            return false;
        else if(node.next().getItem().equals(key))
            return true;
        else
            return find(key,node.next()); 
      
    }
             //adds train to the list
    public void add(String item) 
    {
          add(item, head);
    }
   
    public int getCount()
    {
        return count;
    }
     //aides the public method
    private void add(String item, ListNode x)
    {
        if (x.next() == null) 
        {
            // set to end if necessary
            x.setNext(new ListNode(item));
            count++;
        } 
        else if (x.next().getItem().compareTo(item) > 0)
        {
             // find correct position
            ListNode newNode = new ListNode(item);
            newNode.setNext(x.next());
            x.setNext(newNode);
            count++;
        } 
        else 
        {
            //recursion
         //increment pointer
            add(item, x.next());
        }
    }

    //removes item from list
    //uses private delete as aide
    public String delete(String item) 
    {
        if (head == null) 
            return null;
        else
            return delete(item, head);
    }
    
    public String delete(String item, ListNode x) 
    {
        if (x.next() == null) 
        {
             return null;    //see if no more nodes
        } 
        else if (x.next().getItem().equals(item))
        {
            ListNode temp = x.next();             //found so delete
            x.setNext(x.next().next());
            return temp.getItem();
        } 
        else
        {
            return delete(item, x.next());
        }
    }

}
