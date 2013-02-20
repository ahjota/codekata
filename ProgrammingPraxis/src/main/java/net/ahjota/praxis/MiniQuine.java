package net.ahjota.praxis;
class MiniQuine {
public static void main(String[] args) {
String str = "package net.ahjota.praxis;%nclass MiniQuine {%npublic static void main(String[] args) {%nString str = %c%s%c;%nSystem.out.format(str, 34, str, 34);%n}%n}%n";
System.out.format(str, 34, str, 34);
}
}