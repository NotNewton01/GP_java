public class Main {
	
	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("m = ");
		int m = scanner.nextInt();
		System.out.print("n = ");
		int n = scanner.nextInt();

		// ... ggT und kgV aufrufen
		int ggT=ggT(m,n);
		int kgV=kgV(m,n);
		System.out.printf("ggT( %d, %d) = %d\n", m, n, ggT); 
		System.out.printf("kgV( %d, %d) = %d\n", m, n, kgV); 
	}
	public static int ggT(int m, int n){
		if (m==n){
			return m;
		}
		while (true) { 
			if (m>n){
				m%=n;
			} else {
				n%=m;
			}
			if (m==0){
				return n;
			} else if (n==0){
				return m;
			}
		}
	}
	public static int kgV(int m,int n) {
		m/=ggT(m,n);
		return m*n;
	}
}