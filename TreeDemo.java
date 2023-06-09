class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   /*
   inserts a node into the tree
   */
   public void insert(int value){
      //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;
         
         while(true){
            parent = current;
            
            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }
           
         }//closing while
      
      }//closing main if-else 
   }
   
   
   
   /**
    * pre-order traversal
    * Traverse the binary search tree in pre-order and print the values.
    * @param root The root of the binary search tree.
    */
   public void preOrderTraversal(Node root){
      if(root != null){
         System.out.print(root.value + " ");
         preOrderTraversal(root.left);
         preOrderTraversal(root.right);
      }
   }

   
   
   /**
    * in-order traversal
    * Traverse the binary search tree in in-order and print the values.
    * @param root The root of the binary search tree.
    */
   public void inOrderTraversal(Node root){
      if(root != null){
         inOrderTraversal(root.left);
         System.out.print(root.value + " ");
         inOrderTraversal(root.right);
      }
   }
   
   
   
   /**
    * post-order traversal
    * Traverse the binary search tree in post-order and print the values.
    * @param root The root of the binary search tree.
    */
   public void postOrderTraversal(Node root){
      if(root != null){
         postOrderTraversal(root.left);
         postOrderTraversal(root.right);
         System.out.print(root.value + " ");
      }
   }
   
   
   /**
    * a method to find the node in the tree with a specific value
    * Find a node with the specified value in the binary search tree.
    * @param root The root of the binary search tree.
    * @param key The value to be searched for.
    * @return True if the node is found, false otherwise.
    */
   public boolean find(Node root, int key){
      if(root == null){
         return false;
      }
      if(root.value == key){
         return true;
      }else if(root.value > key){
         return find(root.left, key);
      }else{
         return find(root.right, key);
      }
   }
   
   
   
   /**
    * a method to find the node in the tree with a smallest key
    * Find the node with the smallest value in the binary search tree.
    * @param root The root of the binary search tree.
    * @return The value of the node with the smallest value.
    * @throws NoSuchElementException If the binary search tree is empty.
    */
   public int getMin(Node root){
      if(root.left == null){
         return root.value;
      }else{
         return getMin(root.left);
      }           
   }
  
  
  
   /**
    * a method to find the node in the tree with a largest key
    * Find the node with the largest value in the binary search tree.
    * @param root The root of the binary search tree.
    * @return The value of the node with the largest value.
    * @throws NoSuchElementException If the binary search tree is empty.
    */
   public int getMax(Node root){
      if(root.right == null){
         return root.value;
      }else{
         return getMax(root.right);
      }
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}