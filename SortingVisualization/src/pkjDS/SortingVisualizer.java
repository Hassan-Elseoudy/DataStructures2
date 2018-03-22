package pkjDS;

import javax.swing.*;

import static pkjDS.MyLilPane.setUnits;
import java.util.Arrays;
import java.util.Scanner;


public class SortingVisualizer  {

	private static Scanner s;

	public static void main(String[] args) throws InterruptedException {
		s = new Scanner(System.in);
		System.out.println("Quick Sort = Q \nMerge Sort = M \nHeap Sort = H \nBubble Sort = B \n"
				+ "Insertion Sort = I \nSelection Sort = S \nRadix Sort = R \nCounting Sort = C\n ---------");
		JFrame demo = new JFrame("Sorting Visualizer");
		System.out.println("Please, enter the length of the array?");
		setUnits(s.nextInt());
		System.out.println("Please, enter the speed of animation?");
		MyLilPane.delay = s.nextInt();
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyLilPane pane = new MyLilPane();
		demo.add(pane);
		demo.pack();
		demo.setLocationRelativeTo(null);
		demo.setVisible(true);
		Thread.sleep(3000);
		new Thread(new Runnable() {
			@Override
			public void run() {
				int[] clona = new int[pane.arr.length];
				while (true) {
					if (!Arrays.equals(clona, pane.arr)) {
						pane.repaint();
						clona = pane.arr.clone();
					}

					try {
						Thread.sleep(5);

					} catch (InterruptedException e) {
						System.out.println("Exception!");
					}
				}
			}
		}).start();

		while (true) {
			System.out.println("Sorting Technique?");
			char sc = s.next().charAt(0);
			char sh = '\0';
			switch(sc) {
			case ('Q'):
			case ('q'):
			reset(pane);
			System.out.println("Do you want to shuffle it again?");
			sh = s.next().charAt(0);
			while(sh == 'Y' || sh == 'y') {
				reset(pane);
				sh = s.next().charAt(0);
			}
			pane.setCurrentOperation("Quick Sort");
			pane.setOperationDescription("Θ(n log(n))");
			QuickSort.sort(pane.arr, 0, pane.arr.length - 1);
			Thread.sleep(1000);
			break;
			case ('M'):
			case ('m'):
			reset(pane);
			System.out.println("Do you want to shuffle it again?");
			sh = s.next().charAt(0);
			while(sh == 'Y' || sh == 'y') {
				reset(pane);
				sh = s.next().charAt(0);
			}
			pane.setCurrentOperation("Merge Sort");
			pane.setOperationDescription("Θ(n log(n))");
			MergeSort.mergeSort(pane.arr, 0, pane.arr.length - 1);
			Thread.sleep(1000);
			break;
			case ('H'):
			case ('h'):
			reset(pane);
			System.out.println("Do you want to shuffle it again?");
			sh = s.next().charAt(0);
			while(sh == 'Y' || sh == 'y') {
				reset(pane);
				sh = s.next().charAt(0);
			}
			pane.setCurrentOperation("Heap Sort");
			pane.setOperationDescription("Θ(n log(n))");
			HeapSort.sort(pane.arr);
			Thread.sleep(1000);
			break;
			case ('B'):
			case ('b'):
			reset(pane);
			System.out.println("Do you want to shuffle it again?");
			sh = s.next().charAt(0);
			while(sh == 'Y' || sh == 'y') {
				reset(pane);
				sh = s.next().charAt(0);
			}
			pane.setCurrentOperation("Bubble Sort");
			pane.setOperationDescription("Θ(n^2)");
			SimpleSorts.bubbleSort(pane.arr);
			Thread.sleep(1000);
			break;
			case ('I'):
			case ('i'):
			reset(pane);
			System.out.println("Do you want to shuffle it again?");
			sh = s.next().charAt(0);
			while(sh == 'Y' || sh == 'y') {
				reset(pane);
				sh = s.next().charAt(0);
			}
			pane.setCurrentOperation("Insertion Sort");
			pane.setOperationDescription("Θ(n^2)");
			SimpleSorts.insertionSort(pane.arr);
			Thread.sleep(1000);
			break;
			case ('S'):
			case ('s'):
			reset(pane);
			System.out.println("Do you want to shuffle it again?");
			sh = s.next().charAt(0);
			while(sh == 'Y' || sh == 'y') {
				reset(pane);
				sh = s.next().charAt(0);
			}
			pane.setCurrentOperation("Selection Sort");
			pane.setOperationDescription("Θ(n^2)");
			SimpleSorts.selectionSort(pane.arr);
			Thread.sleep(1000);
			break;
			case ('R'):
			case ('r'):
			reset(pane);
			System.out.println("Do you want to shuffle it again?");
			sh = s.next().charAt(0);
			while(sh == 'Y' || sh == 'y') {
				reset(pane);
				sh = s.next().charAt(0);
			}
			pane.setCurrentOperation("Radix Sort");
			pane.setOperationDescription("Θ(nk)");
			RadixSort.sort(pane.arr);
			Thread.sleep(1000);
			break;
			case ('C'):
			case ('c'):
			reset(pane);
			System.out.println("Do you want to shuffle it again?");
			sh = s.next().charAt(0);
			while(sh == 'Y' || sh == 'y') {
				reset(pane);
				sh = s.next().charAt(0);
			}
			pane.setCurrentOperation("Counting Sort");
			pane.setOperationDescription("Θ(n+k)");
			CountingSort.sort(pane.arr);
			Thread.sleep(1000);
			break;
			default:
				System.out.println("-_-");
			}
		}	
	}

	private static void reset(MyLilPane panel) {
		panel.resetStatistics();
		SimpleSorts.shuffle(panel.arr);
	}
}
