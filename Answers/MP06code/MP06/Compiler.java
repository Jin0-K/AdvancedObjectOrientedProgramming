public interface Compiler {
    /* compile() 함수에서 하는 일
       "Compiling C code: 파일_이름"을 화면에 출력(파일_이름은 SourceCode에 주어진 파일 이름을 사용)
       SourceCode에 있는 파일 이름의 확장자를 .c에서 .obj로 변환한 후에 ObjectCode 객체 생성
       "Generating object code: 오브젝트_파일_이름"을 화면에 출력
       ObjectCode 객체 반환
       예: code로 주어진 SourceCode가 a.c라는 파일 이름을 가지고 있다면 compile() 함수가 호출될 때 다음 내용이 화면에 출력됨
           Compiling C code: a.c
           Generating object code: a.obj
     */
    public ObjectCode compile(SourceCode code);
}
