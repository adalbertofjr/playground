package srpisp

enum class Cargo(val regra: RegraDeCalculo) {
    DESENVOLVEDOR(DezOuVintePorCento()),
    DBA(DezOuVintePorCento()),
    TESTER(QuinzeOuVinteCincoPorCento());
}