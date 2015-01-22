
package the.hasher;

/**
 *
 * @author geraldblake
 */
public class ListNode 
{
    // reference to the next node in the chain,
    // or null if there isn't one.
    protected ListNode next;
    // data carried by  node.
    protected String item;
    
    // Node constructor
    public ListNode(String item)
    {
        next = null;
        this.item= item;
    }
    // specify the node to point to.
    public ListNode(String item, ListNode next)
    {
        this.next = next;
        this.item = item;
    }

    // Return train object
    public String getItem()
    {
         return item;
    }
   //changes train object to specifiied value



    //returns next 
    public ListNode next()
    {
         return next;
    }
  //sets or changes next
    public void setNext(ListNode next)
    {
            this.next = next;
    }

   // returns true if 'this' less than parametric train object
    public boolean lessThan(ListNode node)
    {
        if(this.getItem().compareTo(node.getItem()) < 0)
        {
             return true;
        }
        else
        {
             return false;
        }

    }
    // returns true if 'this' greater than parametric train object
    public boolean greaterThan(ListNode node)
    {

        if(this.getItem().compareTo(node.getItem()) > 0)
        {
               return true;
        }
        else
        {
              return false;
        }

    }
// returns true if 'this' eqaul to parametric train object
    public boolean equal(ListNode node)
    {
        if(this.getItem().equals(node.getItem()))
        {
             return true;
        }
        return false;
    }

}
