/**
* 메모리: 26296 KB, 시간: 540 ms
* 2021.12.14
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N;
	static boolean[] visited = new boolean[1001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = 1;
			map[to][from] = 1;
		}
			
		dfs(start);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(start);
	}
	
	static void dfs(int cur) {
		visited[cur] = true;
		System.out.printf("%d ",cur);
		
		for(int i=1; i <= N; i++) {
			if(map[cur][i] == 1 && !visited[i])
				dfs(i);
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			System.out.printf("%d ",cur);
			for(int i=1; i <= N ; i++) {
				if(map[cur][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}