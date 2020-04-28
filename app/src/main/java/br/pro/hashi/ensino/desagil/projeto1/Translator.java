/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;


public class Translator {
    private Node root;
    private HashMap<Character, Node> map;
    private char[] codeList;



    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {

        map = new HashMap<>();

        // Adiciona node vazio como a raíz da árvore
        root = new Node(' ');
        map.put(root.getValue(),root);

        // Instancia todos os nodes de caracteres
        Node nodeE = new Node('e');
        Node nodeI = new Node('i');
        Node nodeS = new Node('s');
        Node nodeH = new Node('h');
        Node node5 = new Node('5');
        Node node4 = new Node('4');
        Node nodeV = new Node('v');
        Node node3 = new Node('3');
        Node nodeU = new Node('u');
        Node nodeF = new Node('f');
        Node node2 = new Node('2');
        Node nodeA = new Node('a');
        Node nodeR = new Node('r');
        Node nodeL = new Node('l');
        Node nodePlus = new Node('+');
        Node nodeW = new Node('w');
        Node nodeP = new Node('p');
        Node nodeJ = new Node('j');
        Node node1 = new Node('1');
        Node nodeT = new Node('t');
        Node nodeN = new Node('n');
        Node nodeD = new Node('d');
        Node nodeB = new Node('b');
        Node node6 = new Node('6');
        Node nodeEqual = new Node('=');
        Node nodeX = new Node('x');
        Node nodeSlash = new Node('/');
        Node nodeK = new Node('k');
        Node nodeC = new Node('c');
        Node nodeY = new Node('y');
        Node nodeM = new Node('m');
        Node nodeG = new Node('g');
        Node nodeZ = new Node('z');
        Node node7 = new Node('7');
        Node nodeQ = new Node('q');
        Node nodeO = new Node('o');
        Node node8 = new Node('8');
        Node node9 = new Node('9');
        Node node0 = new Node('0');
        Node nodeBlank1 = new Node(' ');
        Node nodeBlank2 = new Node(' ');
        Node nodeBlank3 = new Node(' ');
        Node nodeBlank4 = new Node(' ');

        // Setar todos nodes como parent, left ou right de outro node
        root.setLeft(nodeE);
        root.setRight(nodeT);

        map.put(nodeE.getValue(),nodeE);
        nodeE.setRight(nodeA);
        nodeE.setLeft(nodeI);
        nodeE.setParent(root);

        map.put(nodeT.getValue(),nodeT);
        nodeT.setRight(nodeM);
        nodeT.setLeft(nodeN);
        nodeT.setParent(root);

        map.put(nodeI.getValue(),nodeI);
        nodeI.setRight(nodeU);
        nodeI.setLeft(nodeS);
        nodeI.setParent(nodeE);

        map.put(nodeA.getValue(),nodeA);
        nodeA.setRight(nodeW);
        nodeA.setLeft(nodeR);
        nodeA.setParent(nodeE);

        map.put(nodeN.getValue(),nodeN);
        nodeN.setRight(nodeK);
        nodeN.setLeft(nodeD);
        nodeN.setParent(nodeT);

        map.put(nodeM.getValue(),nodeM);
        nodeM.setRight(nodeO);
        nodeM.setLeft(nodeG);
        nodeM.setParent(nodeT);

        map.put(nodeS.getValue(),nodeS);
        nodeS.setRight(nodeV);
        nodeS.setLeft(nodeH);
        nodeS.setParent(nodeI);

        map.put(nodeU.getValue(),nodeU);
        nodeU.setLeft(nodeF);
        nodeU.setRight(nodeBlank1);
        nodeU.setParent(nodeI);

        map.put(nodeR.getValue(),nodeR);
        nodeR.setLeft(nodeL);
        nodeR.setRight(nodeBlank2);
        nodeR.setParent(nodeA);

        map.put(nodeW.getValue(),nodeW);
        nodeW.setRight(nodeJ);
        nodeW.setLeft(nodeP);
        nodeW.setParent(nodeA);

        map.put(nodeD.getValue(),nodeD);
        nodeD.setRight(nodeX);
        nodeD.setLeft(nodeB);
        nodeD.setParent(nodeN);

        map.put(nodeK.getValue(),nodeK);
        nodeK.setRight(nodeY);
        nodeK.setLeft(nodeC);
        nodeK.setParent(nodeN);

        map.put(nodeG.getValue(),nodeG);
        nodeG.setRight(nodeQ);
        nodeG.setLeft(nodeZ);
        nodeG.setParent(nodeM);

        map.put(nodeO.getValue(),nodeO);
        nodeO.setRight(nodeBlank4);
        nodeO.setLeft(nodeBlank3);
        nodeO.setParent(nodeM);

        map.put(nodeH.getValue(),nodeH);
        nodeH.setRight(node4);
        nodeH.setLeft(node5);
        nodeH.setParent(nodeS);

        map.put(nodeV.getValue(),nodeV);
        nodeV.setRight(node3);
        nodeV.setParent(nodeS);

        map.put(nodeF.getValue(),nodeF);
        nodeF.setParent(nodeU);

        map.put(nodeL.getValue(),nodeL);
        nodeL.setParent(nodeR);

        map.put(nodeP.getValue(),nodeP);
        nodeP.setParent(nodeW);

        map.put(nodeJ.getValue(),nodeJ);
        nodeJ.setRight(node1);
        nodeJ.setParent(nodeW);

        map.put(nodeB.getValue(),nodeB);
        nodeB.setRight(nodeEqual);
        nodeB.setLeft(node6);
        nodeB.setParent(nodeD);

        map.put(nodeX.getValue(),nodeX);
        nodeX.setLeft(nodeSlash);
        nodeX.setParent(nodeD);

        map.put(nodeC.getValue(),nodeC);
        nodeC.setParent(nodeK);

        map.put(nodeY.getValue(),nodeY);
        nodeY.setParent(nodeK);

        map.put(nodeZ.getValue(),nodeZ);
        nodeZ.setLeft(node7);
        nodeZ.setParent(nodeG);

        map.put(nodeQ.getValue(),nodeQ);
        nodeQ.setParent(nodeG);

        map.put(nodeBlank1.getValue(),nodeBlank1);
        nodeBlank1.setRight(node2);
        nodeBlank1.setParent(nodeU);

        map.put(nodeBlank2.getValue(),nodeBlank2);
        nodeBlank2.setLeft(nodePlus);
        nodeBlank2.setParent(nodeR);

        map.put(nodeBlank3.getValue(),nodeBlank3);
        nodeBlank3.setLeft(node8);
        nodeBlank3.setParent(nodeD);

        map.put(nodeBlank4.getValue(),nodeBlank4);
        nodeBlank4.setRight(node0);
        nodeBlank4.setLeft(node9);
        nodeBlank4.setParent(nodeO);

        map.put(node2.getValue(),node2);
        node2.setParent(nodeBlank1);

        map.put(nodePlus.getValue(),nodePlus);
        nodePlus.setParent(nodeBlank2);

        map.put(node8.getValue(),node8);
        node8.setParent(nodeBlank3);

        map.put(node9.getValue(),node9);
        node9.setParent(nodeBlank4);

        map.put(node0.getValue(),node0);
        node0.setParent(nodeBlank4);

        map.put(node1.getValue(),node1);
        node1.setParent(nodeJ);

        map.put(node5.getValue(),node5);
        node5.setParent(nodeH);

        map.put(node4.getValue(),node4);
        node4.setParent(nodeH);

        map.put(node3.getValue(),node3);
        node3.setParent(nodeV);

        map.put(node6.getValue(),node6);
        node6.setParent(nodeB);

        map.put(node7.getValue(),node7);
        node7.setParent(nodeZ);

    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public char morseToChar(String code) {
        Node atual = root;

        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '.'){
                atual = atual.getLeft();
            } else if(code.charAt(i) == '-'){
                atual = atual.getRight();
            } else{
                return ' ';
            }
        }
        return atual.getValue();
    }


        // Você deve mudar o recheio deste método,
        // de acordo com os requisitos do projeto.
        private String charToMorse(Node node) {
        String morseNovo = "";
        String morseTotal = "";
        Node parent = node.getParent();
        boolean parentExists = true;

            while(parentExists == true){
            if (parent.getLeft() == node){
                morseNovo = ".";
                morseTotal.concat(morseNovo);
                node = parent;
            } else if(parent.getRight() == node){
                morseNovo = "-";
                morseTotal.concat(morseNovo);
                node = parent;
            }else{
                parentExists = false;
            }
            //pegar a string de pontos e dashes e invertê-la usando java.util.Scanner
        }

        StringBuilder sb = new StringBuilder(morseTotal);
        String morseFinal = sb.reverse().toString();

        return morseFinal;
        }


        // Este método deve permanecer como está.
        public String charToMorse(char c) {
            return charToMorse(map.get(c));
        }


        // Você deve mudar o recheio deste método,
        // de acordo com os requisitos do projeto.
        public LinkedList<String> getCodes() {
            return new LinkedList<>();
        }
    }
