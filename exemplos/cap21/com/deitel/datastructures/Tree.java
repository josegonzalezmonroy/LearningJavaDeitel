// Fig. 21.17: Tree.java
// Declarações da classe TreeNode e da classe Tree para uma árvore de busca binária.
package com.deitel.datastructures;

// definição da classe TreeNode
class TreeNode<T extends Comparable<T>> 
{
   // membros de acesso ao pacote
   TreeNode<T> leftNode; 
   T data; // valor do nó
   TreeNode<T> rightNode; 

   // construtor inicializa os dados e torna este um nó folha
   public TreeNode(T nodeData)
   { 
      data = nodeData;              
      leftNode = rightNode = null; // o nó não tem filhos
   } 

   // localiza o ponto de inserção e insere um novo nó; ignora valores duplicados
   public void insert(T insertValue)
   {
      // insere na subárvore esquerda
      if (insertValue.compareTo(data) < 0) 
      {
         // insere um novo TreeNode
         if (leftNode == null)
            leftNode = new TreeNode<T>(insertValue);
         else // continua percorrendo a subárvore esquerda recursivamente
            leftNode.insert(insertValue); 
      }
      // insere na subárvore direita
      else if (insertValue.compareTo(data) > 0) 
      {
         // insere um novo TreeNode
         if (rightNode == null)
            rightNode = new TreeNode<T>(insertValue);
         else // continua percorrendo a subárvore direita recursivamente
            rightNode.insert(insertValue); 
      } 
   } 
} // fim da classe TreeNode

// definição da classe Tree
public class Tree<T extends Comparable<T>>
{
   private TreeNode<T> root;

   // construtor inicializa uma árvore vazia de inteiros
   public Tree() 
   { 
      root = null; 
   } 

   // insere um novo nó na árvore de busca binária
   public void insertNode(T insertValue)
   {
      if (root == null)
         root = new TreeNode<T>(insertValue); // cria o nó raiz
      else
         root.insert(insertValue); // chama o método de inserção
   } 

   // inicia a travessia pré-ordem
   public void preorderTraversal()
   { 
      preorderHelper(root); 
   } 

   // método recursivo para realizar a travessia pré-ordem
   private void preorderHelper(TreeNode<T> node)
   {
      if (node == null)
         return;

      System.out.printf("%s ", node.data); // exibe os dados do nó
      preorderHelper(node.leftNode); // percorre a subárvore esquerda
      preorderHelper(node.rightNode); // percorre a subárvore direita
   } 

   // inicia a travessia em-ordem
   public void inorderTraversal()
   { 
      inorderHelper(root); 
   } 

   // método recursivo para realizar a travessia em-ordem
   private void inorderHelper(TreeNode<T> node)
   {
      if (node == null)
         return;

      inorderHelper(node.leftNode); // percorre a subárvore esquerda
      System.out.printf("%s ", node.data); // exibe os dados do nó
      inorderHelper(node.rightNode); // percorre a subárvore direita
   } 

   // inicia a travessia pós-ordem
   public void postorderTraversal()
   { 
      postorderHelper(root); 
   } 

   // método recursivo para realizar a travessia pós-ordem
   private void postorderHelper(TreeNode<T> node)
   {
      if (node == null)
         return;
  
      postorderHelper(node.leftNode); // percorre a subárvore esquerda
      postorderHelper(node.rightNode); // percorre a subárvore direita
      System.out.printf("%s ", node.data); // exibe os dados do nó
   } 
} // fim da classe Tree
