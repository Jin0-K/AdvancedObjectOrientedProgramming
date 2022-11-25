public interface Preprocessor {
    /* preprocess() 함수에서 해야 할 일
        "Preprocessing C code: 파일_이름"을 화면에 출력(파일_이름은 SourceCode에 주어진 파일 이름을 사용)
       SourceCode에 있는 파일 이름의 앞에 "preprocessed_"를 붙여서 새로운 파일 이름을 가진 SourceCode 객체 생성
       "Generating a new C code: 파일_이름"을 화면에 출력. 파일_이름은 code에 주어진 파일 이름에 "preprocessed_"가 붙은 형태
       새로 생성된 SourceCode 객체 반환
       예: code로 주어진 SourceCode가 a.c라는 파일 이름을 가지고 있다면 preprocess() 함수가 호출되면 다음 내용이 화면에 출력되고
           preprocessed_a.c 파일 이름을 가진 새로운 SourceCode 객체가 반환됨
           Preprocessing C code: a.c
           Generating a new C code: preprocessed_a.c
     */
    SourceCode preprocess(SourceCode code);
}
