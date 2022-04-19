//package test;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.List;
//import java.util.TooManyListenersException;
//import java.util.stream.IntStream;
//
//class Result {
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	public static void findMostPopularTopic(List<String> postDetails) {
//
//
//
//	}
//
//}
//public class Solution{
//	
//	
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
//		
//		int postDetailsCount=Integer.parseInt(bufferedReader.readLine().trim());
//		
//		List<String> postDetails =IntStream.range(0, postDetailsCount).mapToObj(i->{
//			
//			
//			
//			try {
//				return bufferedReader.readLine();
//			}catch (IOException ex) {
//				throw new RuntimeException(ex);
//			}
//		})
//			.collect(Tolist());
//			
//			
//		
//			Result.findMostPopularTopic(postDetails);
//			bufferedReader.close();
//		
//		
//		}
//		
//}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
