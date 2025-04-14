import java.util.*;

class Solution {
	class LetterFrequency {
		int letter, frequency;

		LetterFrequency() {
		}

		LetterFrequency(int letter, int freq) {
			this.letter = letter;
			this.frequency = freq;
		}
	}

	public int leastInterval(char[] tasks, int n) {

		Map<Integer, Integer> letterFreqMap = new HashMap<>(26);

		for (char task : tasks)
			letterFreqMap.put(task - 'A', letterFreqMap.getOrDefault(task - 'A', 0) + 1);

		PriorityQueue<LetterFrequency> pq = new PriorityQueue<>(26,
				(a, b) -> -Integer.compare(a.frequency, b.frequency)); // max heap

		for (Map.Entry<Integer, Integer> entry : letterFreqMap.entrySet())
			pq.offer(new LetterFrequency(entry.getKey(), entry.getValue()));

		int totalInterval = 0;
		Set<LetterFrequency> currTaskSet = new HashSet<>(n + 1);

		while (!pq.isEmpty()) {
			currTaskSet.clear();

			for (int i = 0; i < n + 1; i++) {

				if (pq.isEmpty())
					continue;
				LetterFrequency lfCurr = pq.poll();
				lfCurr.frequency--;
				currTaskSet.add(lfCurr);

			}

			for (LetterFrequency lf : currTaskSet)
				if (lf.frequency != 0)
					pq.offer(lf);

			if (pq.isEmpty()) {
				totalInterval += currTaskSet.size();
			} else {

				totalInterval += (n + 1);
			}

		}

		return totalInterval;

	}
}