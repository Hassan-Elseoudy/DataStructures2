package pkjDS;

import javax.swing.*;

import static pkjDS.MyLilPane.setUnits;
import static pkjDS.SimpleSorts.setChoice;
import java.util.Arrays;
import java.util.Scanner;

public class SortingVisualizer {

	private static Scanner s;

	public static void main(String[] args) throws InterruptedException {
		s = new Scanner(System.in);
		System.out.println("Quick Sort = Q \nMerge Sort = M \nHeap Sort = H \nBubble Sort = B \n"
				+ "Insertion Sort = I \nSelection Sort = S \nRadix Sort = R \nCounting Sort = C\n---------");
		System.out.println("1. Random // 2. Reversed // 3. Sorted \n---------");
		JFrame demo = new JFrame("Sorting Visualizer");
		System.out.println("Please, enter the length of the array?");
		setUnits(s.nextInt());
		System.out.println("Please, enter the delay time (ms)?");
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
			int sh = 0;
			switch (sc) {
			case ('Q'):
			case ('q'):
				System.out.println("Enter Shuffling mode?");
				sh = s.nextInt();
				while (!(sh == 1 || sh == 2 || sh == 3)) {
					sh = s.nextInt();
				}
				setChoice(sh, pane.arr);
				pane.setCurrentOperation("Quick Sort");
				pane.setOperationDescription("Θ(n log(n))");
				QuickSort.sort(pane.arr, 0, pane.arr.length - 1);
				Thread.sleep(1000);
				break;
			case ('M'):
			case ('m'):
				System.out.println("Enter Shuffling mode?");
				sh = s.nextInt();
				while (!(sh == 1 || sh == 2 || sh == 3)) {
					sh = s.nextInt();
				}
				setChoice(sh, pane.arr);
				pane.setCurrentOperation("Merge Sort");
				pane.setOperationDescription("Θ(n log(n))");
				MergeSort.mergeSort(pane.arr, 0, pane.arr.length - 1);
				Thread.sleep(1000);
				break;
			case ('H'):
			case ('h'):
				System.out.println("Enter Shuffling mode?");
				sh = s.nextInt();
				while (!(sh == 1 || sh == 2 || sh == 3)) {
					sh = s.nextInt();
				}
				setChoice(sh, pane.arr);
				pane.setCurrentOperation("Heap Sort");
				pane.setOperationDescription("Θ(n log(n))");
				HeapSort.sort(pane.arr);
				Thread.sleep(1000);
				break;
			case ('B'):
			case ('b'):
				System.out.println("Enter Shuffling mode?");
				sh = s.nextInt();
				while (!(sh == 1 || sh == 2 || sh == 3)) {
					sh = s.nextInt();
				}
				setChoice(sh, pane.arr);
				pane.setCurrentOperation("Bubble Sort");
				pane.setOperationDescription("Θ(n^2)");
				SimpleSorts.bubbleSort(pane.arr);
				Thread.sleep(1000);
				break;
			case ('I'):
			case ('i'):
				System.out.println("Enter Shuffling mode?");
				sh = s.nextInt();
				while (!(sh == 1 || sh == 2 || sh == 3)) {
					sh = s.nextInt();
				}
				setChoice(sh, pane.arr);
				pane.setCurrentOperation("Insertion Sort");
				pane.setOperationDescription("Θ(n^2)");
				SimpleSorts.insertionSort(pane.arr);
				Thread.sleep(1000);
				break;
			case ('S'):
			case ('s'):
				System.out.println("Enter Shuffling mode?");
				sh = s.nextInt();
				while (!(sh == 1 || sh == 2 || sh == 3)) {
					sh = s.nextInt();
				}
				setChoice(sh, pane.arr);
				pane.setCurrentOperation("Selection Sort");
				pane.setOperationDescription("Θ(n^2)");
				SimpleSorts.selectionSort(pane.arr);
				Thread.sleep(1000);
				break;
			case ('R'):
			case ('r'):
				System.out.println("Enter Shuffling mode?");
				sh = s.nextInt();
				while (!(sh == 1 || sh == 2 || sh == 3)) {
					sh = s.nextInt();
				}
				setChoice(sh, pane.arr);
				pane.setCurrentOperation("Radix Sort");
				pane.setOperationDescription("Θ(nk)");
				RadixSort.sort(pane.arr);
				Thread.sleep(1000);
				break;
			case ('C'):
			case ('c'):
				System.out.println("Enter Shuffling mode?");
				sh = s.nextInt();
				while (!(sh == 1 || sh == 2 || sh == 3)) {
					sh = s.nextInt();
				}
				setChoice(sh, pane.arr);
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
