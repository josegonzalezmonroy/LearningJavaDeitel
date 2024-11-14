// Fig. 21.17: Tree.java
// Declarações da classe TreeNode e da classe Tree para uma arvore de busca binaria.
package com.deitel.datastructures;

// definiçao da classe TreeNode
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
      leftNode = rightNode = null; // o nó nao tem filhos
   } 

   // localiza o ponto de inserçao e insere um novo nó; ignora valores duplicados
   public void insert(T insertValue)
   {
      // insere na subarvore esquerda
      if (insertValue.compareTo(data) < 0) 
      {
         // insere um novo TreeNode
         if (leftNode == null)
            leftNode = new TreeNode<T>(insertValue);
         else // continua percorrendo a subarvore esquerda recursivamente
            leftNode.insert(insertValue); 
      }
      // insere na subarvore direita
      else if (insertValue.compareTo(data) >= 0) 
      {
         // insere um novo TreeNode
         if (rightNode == null)
            rightNode = new TreeNode<T>(insertValue);
         else // continua percorrendo a subarvore direita recursivamente
            rightNode.insert(insertValue); 
      } 
   } 
} // fim da classe TreeNode

// definiçao da classe Tree
public class Tree<T extends Comparable<T>>
{
   private TreeNode<T> root;
   private int depth;

   // construtor inicializa uma arvore vazia de inteiros
   public Tree() 
   { 
      root = null; 
   } 

   // insere um novo nó na arvore de busca binaria
   public void insertNode(T insertValue)
   {
      if (root == null)
         root = new TreeNode<T>(insertValue); // cria o nó raiz
      else
         root.insert(insertValue); // chama o método de inserçao

      depth++;
   }

   public int getDepth()
   {
      return depth;
   }

   public void deleteNode(T value) 
   {
      // Verifica se a raiz da arvore esta vazia
      if (root == null)
      {
         System.out.println("\narvore vazia"); // Exibe mensagem se a arvore nao tiver elementos
         return;      
      }
       
      root = deleteNode(root, value); // Aqui, sempre reasignamos `root` após a exclusao
   }
   
   private TreeNode<T> deleteNode(TreeNode<T> node, T value) 
   {
      // Se o nó atual for nulo, o valor nao foi encontrado
      if (node == null)
      {
         System.out.printf("%nValor %s nao encontrado", value);
         return null;   
      }
   
      if (value.compareTo(node.data) < 0) 
         // Busca no subarbol esquerdo se o valor é menor
         node.leftNode = deleteNode(node.leftNode, value);
      else if (value.compareTo(node.data) > 0)
         // Busca no subarbol direito se o valor é maior
         node.rightNode = deleteNode(node.rightNode, value);
      else
         // O nó a ser excluído foi encontrado
         if (node.leftNode == null && node.rightNode == null) 
            // Caso 1: O nó é uma folha (nao tem filhos)
            return null; // Retorna nulo para excluir o nó
         else if (node.leftNode == null) 
            // Caso 2: O nó tem apenas um filho à direita
            return node.rightNode; // Retorna o filho à direita
         else if (node.rightNode == null)
            // Caso 3: O nó tem apenas um filho à esquerda
            return node.leftNode; // Retorna o filho à esquerda
         else 
         {
            // Caso 4: O nó tem dois filhos
            TreeNode<T> tempNode = findMin(node.rightNode); // Encontra o mínimo no subarbol direito
            node.data = tempNode.data; // Substitui o valor do nó a ser excluído pelo valor mínimo encontrado
            node.rightNode = deleteNode(node.rightNode, tempNode.data); // Remove o nó duplicado do subarbol direito
         }
   
      return node; // Retorna o nó atualizado após a exclusao
   }
   
   // Método para encontrar o nó com o menor valor no subarbol
   private TreeNode<T> findMin(TreeNode<T> node)
   {
      // Percorre o subarbol à esquerda até encontrar o nó mais à esquerda
      while (node.leftNode != null)
      {
         node = node.leftNode;   
      }
      return node; // Retorna o nó com o menor valor
   }
   
   public TreeNode<T> contains(T value) 
   {
      // Verifica se a arvore esta vazia
      if (root == null) 
      {
         System.out.println("\nEmpty tree"); // Exibe mensagem se a arvore nao tiver elementos
         return null;
      }
   
      // Chama o método privado search para buscar o valor a partir da raiz
      TreeNode<T> nodeSearch = search(root, value);
   
      // Exibe se o valor foi ou nao encontrado
      System.out.printf("%nValue %s %sfound%n", value, nodeSearch == null ? "not " : "");

      return nodeSearch;
   }   

   private TreeNode<T> search(TreeNode<T> node, T value)
   {
      if (node == null) 
         return null; // Se o nó é null, significa que o valor nao foi encontrado neste caminho
   
      if (node.data.equals(value)) 
         return node; // Se encontrou o valor, retorna o nó atual
   
      // Busca recursivamente no subarvore esquerdo
      TreeNode<T> leftResult = search(node.leftNode, value);

      if (leftResult != null) 
         return leftResult; // Se encontrou no lado esquerdo, retorna o nó encontrado
   
      // Se nao encontrou no lado esquerdo, busca no subarvore direito
      return search(node.rightNode, value); 
   }

   // inicia a travessia pré-ordem
   public void preorderTraversal()
   { 
      preorderHelper(root); 
      System.out.println(); 
   } 

   // método recursivo para realizar a travessia pré-ordem
   private void preorderHelper(TreeNode<T> node)
   {
      if (node == null)
         return;

      System.out.printf("%s ", node.data); // exibe os dados do nó
      preorderHelper(node.leftNode); // percorre a subarvore esquerda
      preorderHelper(node.rightNode); // percorre a subarvore direita
   } 

   // inicia a travessia em-ordem
   public void inorderTraversal()
   { 
      inorderHelper(root);
      System.out.println(); 
   } 

   // método recursivo para realizar a travessia em-ordem
   private void inorderHelper(TreeNode<T> node)
   {
      if (node == null)
         return;

      inorderHelper(node.leftNode); // percorre a subarvore esquerda
      System.out.printf("%s ", node.data); // exibe os dados do nó
      inorderHelper(node.rightNode); // percorre a subarvore direita
   } 

   // inicia a travessia pós-ordem
   public void postorderTraversal()
   { 
      postorderHelper(root);
      System.out.println(); 
   } 

   // método recursivo para realizar a travessia pós-ordem
   private void postorderHelper(TreeNode<T> node)
   {
      if (node == null)
         return;
  
      postorderHelper(node.leftNode); // percorre a subarvore esquerda
      postorderHelper(node.rightNode); // percorre a subarvore direita
      System.out.printf("%s ", node.data); // exibe os dados do nó
   }
   
   public void levelOrder()
   {
      // Verifica se a arvore esta vazia
      if (root == null) 
      {
         System.out.println("\narvore vazia"); // Exibe mensagem se a arvore não tiver elementos
         return;
      }
   
      Queue<TreeNode<T>> fila = new Queue<>(); // Cria uma fila para armazenar os nós a serem processados
   
      fila.enqueue(root); // Insere o nó raiz na fila
   
      // Enquanto houver nós na fila
      while (!fila.isEmpty()) 
      {
         TreeNode<T> currentNode = fila.dequeue(); // Remove o primeiro nó da fila e armazena em currentNode
   
         System.out.print(currentNode.data + " "); // Imprime o valor do nó atual
   
         // Se o nó atual tiver um filho à esquerda, insere esse nó na fila
         if (currentNode.leftNode != null) 
            fila.enqueue(currentNode.leftNode);
   
         // Se o nó atual tiver um filho à direita, insere esse nó na fila
         if (currentNode.rightNode != null) 
            fila.enqueue(currentNode.rightNode);
      }
      System.out.println(); // Adiciona uma linha após a travessia
   }

   // Método público que inicia a impressão da árvore
   public void outputTree() 
   {
      outputTree(root, 0); // Chama o método privado com a raiz e 0 espaços iniciais
   }

   // Método privado recursivo para imprimir a árvore
   private void outputTree(TreeNode<T> node, int totalSpaces) 
   {
      if (node == null) // Se o nó atual for nulo, termina a execução
         return;

      // Chama recursivamente o nó da direita, aumentando o número de espaços
      outputTree(node.rightNode, totalSpaces + 5);

      // Imprime espaços em branco para o alinhamento do nó atual
      for (int i = 1; i <= totalSpaces; i++) 
         System.out.print(" "); // Imprime espaços à esquerda do nó

      // Imprime o valor do nó atual
      System.out.println(node.data);

      // Chama recursivamente o nó da esquerda, aumentando o número de espaços
      outputTree(node.leftNode, totalSpaces + 5);
   }
} // fim da classe Tree
