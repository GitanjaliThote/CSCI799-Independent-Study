import java.util.*;

public class FordFulkersonMaxFlow {

    public static boolean bfsPath(int [][] graph, int start, int end,int [] predecessor){

        Queue<Integer> q = new LinkedList();
        List<Integer> visited = new ArrayList<>();

        for(int i = 0; i < predecessor.length; i++)
            predecessor[i] = -1;


        q.add(start);
        visited.add(start);


        while(!q.isEmpty()){
            int vertex = q.poll();
            if(vertex == end)
                return true;
            else{

                for(int edge =0; edge < graph.length;edge++){
                    if(graph[vertex][edge] > 0 && !visited.contains(edge)){
                        q.add(edge);
                        predecessor[edge] = vertex;
                        visited.add(edge);

                    }
                }
            }
        }

        return false;
    }

    public static int fordFulkersonMaxFlow(int [][] graph, int start, int end){

        int noOfVertex = graph.length;
        int [][] residualGraph = new int [noOfVertex][noOfVertex];

        for (int i = 0; i < noOfVertex; i++) {
           for(int j = 0; j < noOfVertex ;j++){
               residualGraph[i][j] = graph[i][j];
           }
        }

        int maxFlow = 0;

        int [] predecessor = new int[graph.length];

        while(bfsPath(residualGraph,start,end,predecessor)){

            int minPathFlow = Integer.MAX_VALUE;
            for(int i = end; i !=start; i = predecessor[i]){
                minPathFlow = Math.min(minPathFlow,graph[predecessor[i]][i]);
            }

            for(int i = end; i !=start; i = predecessor[i]){
                int vertex= predecessor[i];
                residualGraph[ vertex ][i] -= minPathFlow;
                residualGraph[i][ vertex ] += minPathFlow;
            }

            maxFlow += minPathFlow;
        }


        return maxFlow;

    }


    public static void main (String[] args) throws java.lang.Exception
    {
        // Let us create a graph shown in the above example
        int graph[][] =new int[][] { {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };
        FordFulkersonMaxFlow m = new FordFulkersonMaxFlow();

        System.out.println("The maximum possible flow is " +
                m.fordFulkersonMaxFlow(graph, 0, 5));

    }
}
