package spring;

import lombok.Setter;

@Setter
public class VersionPrinter {
	private int majorVersion;
	private int minorVersion;

	public void print() {
		System.out.printf("이 프로그램의 버전은 %d.%d입니다.\n\n",
				majorVersion, minorVersion);
	}

}
