import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

	/**
	 * Load graphs in from filesystem and perform Kruskal Minimum
	 * Spanning Tree on each
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = null;
		Stream<Path> walk = null;
		try {
			
			walk = Files.walk(Paths.get("C:\\data"));
			
			List<String> result = walk.filter(Files::isRegularFile)
					.map(x -> x.toString()).collect(Collectors.toList());
			
			for (String filePath : result) {
				br = new BufferedReader(new FileReader(filePath));
				List<String> edges = new ArrayList<>();
				int v = 0;
				String line;
				while ((line = br.readLine()) != null) {
					String elements[] = line.split("\\t");
					if (elements.length == 1) {
						v= Integer.parseInt(elements[0]);
					} else {
						edges.add(line);
					}
				}
				int e = edges.size();
				Graph graph = new Graph(v,e);
				
				String[] edgesArray = edges.toArray(new String[edges.size()]);
				
				for (int i = 0; i < edges.size(); i++) {
					String elements[] = edgesArray[i].split("\\t");
					graph.edge[i].src = Integer.parseInt(elements[0]);
					graph.edge[i].dest = Integer.parseInt(elements[1]);
					graph.edge[i].weight = Integer.parseInt(elements[2]);
							
				}
				Kruskal.kruskal(graph);
			}
			
			
		} catch (IOException ex) {
			System.out.println("We have failed to access the local data, "
					+ "please ensure environment is set up properly");
			ex.printStackTrace();
		}
		finally {
			try {
				br.close();
				walk.close();
				
			} catch (IOException e) {
				System.out.println("We have failed to close our resources, please investigate");
				e.printStackTrace();
			}
		}
		
	}
}
