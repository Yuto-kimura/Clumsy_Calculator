package careless.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Agreement(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 15.dp).verticalScroll(rememberScrollState())
    ) {
        TextWithStyle(text = "利用規約", fontSize = 24.sp, fontWeight = FontWeight.Bold, paddingBottom = 8.dp)
        TextWithStyle(text = "この利用規約（以下，「本規約」といいます。）は，木村勇斗（以下，「当方」といいます。）がこのウェブサイト上で提供するサービス（以下，「本サービス」といいます。）の利用条件を定めるものです。登録ユーザーの皆さま（以下，「ユーザー」といいます。）には，本規約に従って，本サービスをご利用いただきます。")
        Spacer(Modifier.height(15.dp))

        SectionTitle("第1条（適用）")
        ProhibitedActionsList(
            listOf(
                "本規約は，ユーザーと当方との間の本サービスの利用に関わる一切の関係に適用されるものとします。",
                "当方は本サービスに関し，本規約のほか，ご利用にあたってのルール等，各種の定め（以下，「個別規定」といいます。）をすることがあります。これら個別規定はその名称のいかんに関わらず，本規約の一部を構成するものとします。",
                "本規約の規定が前条の個別規定の規定と矛盾する場合には，個別規定において特段の定めなき限り，個別規定の規定が優先されるものとします。"
            )
        )
        Spacer(Modifier.height(15.dp))

        SectionTitle("第2条（禁止事項）")
        ProhibitedActionsList(
            listOf(
                "法令または公序良俗に違反する行為",
                "犯罪行為に関連する行為",
                "本サービスの内容等，本サービスに含まれる著作権，商標権ほか知的財産権を侵害する行為",
                "当方，ほかのユーザー，またはその他第三者のサーバーまたはネットワークの機能を破壊したり，妨害したりする行為",
                "本サービスによって得られた情報を商業的に利用する行為",
                "当方のサービスの運営を妨害するおそれのある行為",
                "不正アクセスをし，またはこれを試みる行為",
                "他のユーザーに関する個人情報等を収集または蓄積する行為",
                "不正な目的を持って本サービスを利用する行為",
                "本サービスの他のユーザーまたはその他の第三者に不利益，損害，不快感を与える行為",
                "他のユーザーに成りすます行為",
                "当方が許諾しない本サービス上での宣伝，広告，勧誘，または営業行為",
                "面識のない異性との出会いを目的とした行為",
                "当方のサービスに関連して，反社会的勢力に対して直接または間接に利益を供与する行為",
                "その他，当方が不適切と判断する行為"
            )
        )
        Spacer(Modifier.height(15.dp))

        SectionTitle("第3条（本サービスの提供の停止等）")
        TextWithStyle(text = "当方は，以下のいずれかの事由があると判断した場合，ユーザーに事前に通知することなく本サービスの全部または一部の提供を停止または中断することができるものとします。", paddingBottom = 8.dp)
        ProhibitedActionsList(
            listOf(
                "本規約のいずれかの条項に違反した場合",
                "登録事項に虚偽の事実があることが判明した場合",
                "料金等の支払債務の不履行があった場合",
                "当方からの連絡に対し，一定期間返答がない場合",
                "本サービスについて，最終の利用から一定期間利用がない場合",
                "その他，当方が本サービスの利用を適当でないと判断した場合"
            )
        )
        TextWithStyle(text = "当方は，本サービスの提供の停止または中断により，ユーザーまたは第三者が被ったいかなる不利益または損害についても，一切の責任を負わないものとします。")
        Spacer(Modifier.height(15.dp))

        SectionTitle("第4条（保証の否認および免責事項）")
        TextWithStyle(text = "当方は，本サービスに事実上または法律上の瑕疵（安全性，信頼性，正確性，完全性，有効性，特定の目的への適合性，セキュリティなどに関する欠陥，エラーやバグ，権利侵害などを含みます。）がないことを明示的にも黙示的にも保証しておりません。")
        Spacer(Modifier.height(15.dp))

        SectionTitle("第5条（サービス内容の変更等）")
        TextWithStyle(text = "当方は，ユーザーへの事前の告知をもって、本サービスの内容を変更、追加または廃止することがあり、ユーザーはこれを承諾するものとします。")
        Spacer(Modifier.height(15.dp))

        SectionTitle("第6条（利用規約の変更）")
        TextWithStyle(text = "当方は，以下のいずれかの事由があると判断した場合，ユーザーに事前に通知することなく本サービスの全部または一部の提供を停止または中断することができるものとします。")
        ProhibitedActionsList(
            listOf(
                "本規約の変更がユーザーの一般の利益に適合するとき。",
                "本規約の変更が本サービス利用契約の目的に反せず、かつ、変更の必要性、変更後の内容の相当性その他の変更に係る事情に照らして合理的なものであるとき。"
            )
        )
        TextWithStyle(text = "当方はユーザーに対し、前項による本規約の変更にあたり、事前に、本規約を変更する旨及び変更後の本規約の内容並びにその効力発生時期を通知します。")
        Spacer(Modifier.height(15.dp))

        // 第7条
        SectionTitle("第15条（準拠法・裁判管轄）")
        TextWithStyle(text = "本規約の解釈にあたっては，日本法を準拠法とします。")
        TextWithStyle(text = "本サービスに関して紛争が生じた場合には，当方の本店所在地を管轄する裁判所を専属的合意管轄とします。")
        Spacer(Modifier.height(15.dp))
    }
}

@Composable
private fun TextWithStyle(
    text: String,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight? = null,
    paddingBottom: Dp = 0.dp
) {
    Text(
        text = text,
        style = TextStyle(fontSize = fontSize, fontWeight = fontWeight),
        modifier = Modifier.padding(bottom = paddingBottom)
    )
}

@Composable
private fun SectionTitle(text: String) {
    TextWithStyle(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        paddingBottom = 8.dp
    )
}

@Composable
private fun ProhibitedActionsList(actions: List<String>) {
    actions.forEachIndexed { index, action ->
        TextWithStyle(
            text = "${index + 1}. $action",
            fontSize = 16.sp,
            paddingBottom = 8.dp
        )
    }
}

@Preview
@Composable
fun AgreementPreview() {
    Agreement()
}
