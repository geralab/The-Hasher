
package the.hasher;
/**
 * @author geraldblake
 */
public class SetOfStrings 
{
   //data members
    protected int count;
    protected LinkedList [] hashArray;
    protected int size;

    /**
     *
     * @param numberOfSlots
     */
    public SetOfStrings(int numberOfSlots)
    {
        hashArray = new LinkedList[numberOfSlots];
        size = numberOfSlots;
        for(int i = 0; i < numberOfSlots;i++)
        {
            hashArray[i] = new LinkedList();
        }
        count = 0;
    }
    /**
     *Size of the hash table
     * @return
     */
    public int size()
    {
        return size;
    }

    /**
     *adds item to the list
     * @param item
     * @return
     */
    public boolean add(String item)
    {
        int index = hash(item);
        if(!hashArray[index].find(item))
        {
            hashArray[index].add(item);
            count++;
            return true;
        }
        return false;
    }

    /**
     * number of items in the hash table
     * @return
     */
    public int count()
    {
        return count;
    }

    /**
     * deletes item from a hash table
     * @param item
     * @return 
     */
    public boolean delete(String item)
    {
        int index = hash(item);
        if(hashArray[index].delete(item)!=null)
        {
            count--;
            return true;
        }
        return false;
    }
   
    /**
     *
     * @param item
     * @return number of comparisons it takes to find string n
     * negative if not found
     */
    public int contains(String item)
    {
        int index = hash(item);
        ListNode node = hashArray[index].head();
        int comparisons = 1;
     
        while(node.next()!=null)
        {
            if(node.next().getItem().equals(item))
            {
                return comparisons;
            }
            node = node.next();
            comparisons++;
        }
        return -comparisons;
    
    }
    
    /**
     *
     * @param hashString
     * @return index at which string hashes
     */
    public int hash(String hashString)
    {
        char[] theCharArray = hashString.toCharArray();
        int sum = 0;
        for(char theChar:theCharArray)
        {
            sum += theChar;
        }
        return sum % size();
    }
    
    
    public int hash2(String hashString)
    {
        int sum = 0;
        for(int i = 0; i < hashString.length();i++)
        {
                sum+=hashString.charAt(i);
        }
        return sum % size();
    }
    
}
