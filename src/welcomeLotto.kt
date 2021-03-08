import java.util.*

/**************************************************
 * @author  서지혜
 * @created 2021.03.08
 * @desc    랜덤 로또 프로그램 (7개 숫자 랜덤 획득)
 **************************************************/

const val MIN_NUM = 1         // 로또번호를 추출할 최소값
const val TOT_NUM = 45        // 로또번호를 추출할 최대값 (45일 경우 1에서 45까지 추출)

const val BUY_MAX = 5         // 구매 가능한 로또 라인수
const val MAX_NUM = 7         // 한 행에 추출할 최대 개수

var BUY_NUM:Int = 0           // 사용자가 입력한 로또 라인수 초기화


fun main(){

    //환영 메시지
    setMsg("welcome")

    //구입매수 입력 & 체크
    buyLotto()

}


/***********************************************
 * 시스템 접속 or 종료 시 메시지
 ***********************************************/
fun setMsg(stus:String)
{
    var msg = ""

    if(stus == "welcome")
    {
        msg = """※ 어서오세요. 웰컴로또 시스템입니다 *^^* 
                 |  구매할 라인수를 입력해 주세요 (최대 ${BUY_MAX} 라인까지 구매 가능)""".trimMargin()
    } else {

        println("********************************\n")
        msg = "※ 이용해 주셔서 감사합니다 *^^* \n※ 대박기원!! "
    }

    println(msg)
}


/***********************************************
 * 구입매수 입력 & 체크
 ***********************************************/
fun buyLotto(){

    // 사용자가 입력한 로또 라인수
    BUY_NUM = Scanner(System.`in`).nextInt()

    // 사용자 입력값 확인
    if(BUY_NUM in 1..BUY_MAX)
    {
        println("\n[신청 : ${BUY_NUM} 라인] 번호 추출 중... \n잠시만 기다려 주세요.\n")
        println("***** 로또 번호 *****************")

        //로또번호 생성
        getLottoNum()

        //종료 메시지
        setMsg("bye")

    }else {
        println("\n※ [알림] 입력 매수를 확인해 주세요 (최대 ${BUY_MAX} 라인까지 구매 가능)")
    }

    /*
    when(buyNum) {
        in 1..5 -> println("\n[신청 : ${buyNum} 라인] 번호 추출 중... 잠시만 기다려 주세요.")
        else -> println("※ 입력 매수를 확인해 주세요 (최대 ${count} 라인까지 구매 가능)")
    }
     */
}


/***********************************************
 * 로또번호 추출
 ***********************************************/
fun getLottoNum()
{
    // 사용자가 구입한 라인수 만큼 추출
    for(i in 1..BUY_NUM)
    {
        var arryList = ArrayList<Int>()

        
        // 한 행에 추출할 최대 개수 만큼 랜덤번호 추출
        for(j in 1..MAX_NUM)
        {
            // 최소 숫자 ~ 최대 숫자 사이에 중 랜덤 추출
            var num = (MIN_NUM..TOT_NUM).random()
            arryList.add(num)
        }

        // 중복추출 번호 확인
        var chkSize = arryList.distinct().size


        // 중복번호 제거 후 최대 추출개수 보다 작으면 추가 추출
        if(chkSize < MAX_NUM)
        {
            while(arryList.distinct().size != MAX_NUM)
            {
                // 최소 숫자 ~ 최대 숫자 사이에 중 랜덤 추출
                var num = (MIN_NUM..TOT_NUM).random()
                arryList.add(num)
            }

        }

        // 로또번호 출력 & 정렬
        println(arryList.distinct().sortedBy{it.dec()})

    }
}