def String convert(String str, int fromBase, int toBase) {
    toStr(toInteger(str,fromBase),toBase)    
}

def String toStr(int number, int base) {
    toStr("",number,base).reverse()
}

def String toStr(String result, int number, int base) {
//    println "toStr("+result+","+number+","+base+")..."
    if (number == 0) result 
    else toStr(result+toChar(number%base),(int)(number/base),base)
}

def int toInteger(String str, int base) {
    final char[] chars = str.reverse().toCharArray();
    int result = 0;
    for(int i=0;i<chars.length;i++) {
        int d = toDigit(chars[i]);
        if (d >= base) throw new IllegalArgumentException("illegal character '"+chars[i]+"' for base '"+base+"'")
        result = result + d * (int)Math.pow(base,i);
    }
    result;
}

def char toChar(int d) {
    final char[] DIGITS = "0123456789ABCEF".toCharArray();
    DIGITS[d]
}

def int toDigit(char ch) {
    final char[] DIGITS = "0123456789ABCEF".toCharArray();
    for(int i=0;i<DIGITS.length;i++) {
        if (ch == DIGITS[i]) return i;
    }
}

assert toChar(0)=="0"
assert toChar(12)=="C"

assert toDigit('A' as char)==10

assert toInteger("123",10)==123
assert toInteger("10",8)==8
assert toInteger("123ABCF",16)==19114958

assert toStr(1234,10)=="1234"
assert toStr(19114958,16)=="123ABCF"

assert convert("19114958",10,16)=="123ABCF"
assert convert("123ABCF",16,10)=="19114958"
