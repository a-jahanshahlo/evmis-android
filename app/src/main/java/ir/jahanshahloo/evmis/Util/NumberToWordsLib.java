package ir.jahanshahloo.evmis.Util;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ali on 8/11/2016.
 */

public class NumberToWordsLib {
    public enum Language {
        English,
        Persian
    }

    public enum DigitGroup {
        /// <summary>
        /// Ones group
        /// </summary>
        Ones,

        /// <summary>
        /// Teens group
        /// </summary>
        Teens,

        /// <summary>
        /// Tens group
        /// </summary>
        Tens,

        /// <summary>
        /// Hundreds group
        /// </summary>
        Hundreds,

        /// <summary>
        /// Thousands group
        /// </summary>
        Thousands
    }


    public static class NumberWord {

        public static NumberWord getNewNumberWord() {
            return new NumberWord();
        }

        private DigitGroup _digitalGroup;
        private Language _Language;

        private List<String> _Names;


        public DigitGroup getDigitalGroup() {
            return _digitalGroup;
        }

        public void setDigitalGroup(DigitGroup _digitalGroup) {
            this._digitalGroup = _digitalGroup;
        }

        public NumberToWordsLib.Language getLanguage() {
            return _Language;
        }

        public void setLanguage(NumberToWordsLib.Language _Language) {
            this._Language = _Language;
        }

        public List<String> getNames() {
            return _Names;
        }

        public void setNames(List<String> _Names) {
            this._Names = _Names;
        }
    }


    /// <summary>
    /// Convert a number into words
    /// </summary>
    public static class HumanReadableInteger {

        static {


        }

        private static final Map<Language, String> And =
                Collections.unmodifiableMap(new HashMap<Language, String>() {{
                    put(Language.English, " ");
                    put(Language.Persian, " و ");
                }});


        static Collection<NumberWord> myCollection = new ArrayList<NumberWord>(new ArrayList<NumberWord>() {{
            add(new NumberWord() {{
                setLanguage(Language.English);
                setNames(new ArrayList<String>() {{
                    add("");
                    add("One");
                    add("Two");
                    add("Three");
                    add("Four");
                    add("Five");
                    add("Six");
                    add("Seven");
                    add("Eight");
                    add("Nine");
                }});
                setDigitalGroup(DigitGroup.Ones);
            }});
                /**/
            add(new NumberWord() {{
                setLanguage(Language.Persian);
                setNames(new ArrayList<String>() {{
                    add("");
                    add("یک");
                    add("دو");
                    add("سه");
                    add("چهار");
                    add("پنج");
                    add("شش");
                    add("هفت");
                    add("هشت");
                    add("نه");
                }});
                setDigitalGroup(DigitGroup.Ones);
            }});
             /**/
            add(new NumberWord() {{
                setLanguage(Language.English);
                setNames(new ArrayList<String>() {{

                    add("Ten");
                    add("Eleven");
                    add("Thirteen");
                    add("Fourteen");
                    add("Fifteen");
                    add("Sixteen");
                    add("Seventeen");
                    add("Eighteen");
                    add("Nineteen");
                }});
                setDigitalGroup(DigitGroup.Teens);
            }});
                /**/
            add(new NumberWord() {{
                setLanguage(Language.Persian);
                setNames(new ArrayList<String>() {{

                    add("ده");
                    add("یازده");
                    add("دوازده");
                    add("سیزده");
                    add("چهارده");
                    add("پانزده");
                    add("شانزده");
                    add("هفده");
                    add("هجده");
                    add("نوزده");

                }});
                setDigitalGroup(DigitGroup.Teens);
            }});

            add(new NumberWord() {{
                setLanguage(Language.English);
                setNames(new ArrayList<String>() {{
                    add("Twenty");
                    add("Thirty");
                    add("Forty");
                    add("Fifty");
                    add("Sixty");
                    add("Seventy");
                    add("Eighty");
                    add("Ninety");
                }});
                setDigitalGroup(DigitGroup.Tens);
            }});
                /**/
            add(new NumberWord() {{
                setLanguage(Language.Persian);
                setNames(new ArrayList<String>() {{
                    add("بیست");
                    add("سی");
                    add("چهل");
                    add("پنجاه");
                    add("شصت");
                    add("هفتاد");
                    add("هشتاد");
                    add("نود");
                }});
                setDigitalGroup(DigitGroup.Tens);
            }});

            add(new NumberWord() {{
                setLanguage(Language.English);
                setNames(new ArrayList<String>() {{
                    add("");

                    add("One Hundred");
                    add("Two Hundred");
                    add("Three Hundred");
                    add("Four Hundred");
                    add("Five Hundred");
                    add("Six Hundred");
                    add("Seven Hundred");
                    add("Eight Hundred");
                    add("Nine Hundred");

                }});
                setDigitalGroup(DigitGroup.Hundreds);
            }});
                /**/
            add(new NumberWord() {{
                setLanguage(Language.Persian);
                setNames(new ArrayList<String>() {{
                    add("");
                    add("یکصد");
                    add("دویست");
                    add("سیصد");
                    add("چهارصد");
                    add("پانصد");
                    add("ششصد");
                    add("هفتصد");
                    add("هشتصد");
                    add("نهصد");

                }});
                setDigitalGroup(DigitGroup.Hundreds);
            }});

            add(new NumberWord() {{
                setLanguage(Language.English);
                setNames(new ArrayList<String>() {{
                    add("");
                    add("One Hundred");
                    add(" Thousand");
                    add(" Million");
                    add(" Billion");
                    add(" Trillion");
                    add(" Quadrillion");
                    add(" Quintillion");
                    add(" Sextillian");
                    add(" Octillion");
                    add(" Nonillion");
                    add(" Decillion");
                    add(" Undecillion");
                    add(" Duodecillion");
                    add(" Tredecillion");
                    add(" Quattuordecillion");
                    add(" Quindecillion");
                    add(" Sexdecillion");
                    add(" Septendecillion");
                    add(" Octodecillion");
                    add(" Novemdecillion");
                    add(" Vigintillion");
                    add(" Unvigintillion");
                    add(" Duovigintillion");
                    add(" 10^72");
                    add(" 10^75");
                    add(" 10^78");
                    add(" 10^81");
                    add(" 10^84");
                    add(" 10^87");
                    add(" Vigintinonillion");
                    add(" 10^93");
                    add(" 10^96");
                    add(" Duotrigintillion");
                    add(" Trestrigintillion");


                }});
                setDigitalGroup(DigitGroup.Thousands);
            }});
                /**/
            add(new NumberWord() {{
                setLanguage(Language.Persian);
                setNames(new ArrayList<String>() {{
                    add("");
                    add(" هزار");
                    add(" میلیون");
                    add(" میلیارد");
                    add(" تریلیون");
                    add(" Quadrillion");
                    add(" Quintillion");
                    add(" Sextillian");
                    add(" Octillion");
                    add(" Nonillion");
                    add(" Decillion");
                    add(" Undecillion");
                    add(" Duodecillion");
                    add(" Tredecillion");
                    add(" Quattuordecillion");
                    add(" Quindecillion");
                    add(" Sexdecillion");
                    add(" Septendecillion");
                    add(" Octodecillion");
                    add(" Novemdecillion");
                    add(" Vigintillion");
                    add(" Unvigintillion");
                    add(" Duovigintillion");
                    add(" 10^72");
                    add(" 10^75");
                    add(" 10^78");
                    add(" 10^81");
                    add(" 10^84");
                    add(" 10^87");
                    add(" Vigintinonillion");
                    add(" 10^93");
                    add(" 10^96");
                    add(" Duotrigintillion");
                    add(" Trestrigintillion");

                }});
                setDigitalGroup(DigitGroup.Thousands);
            }});


        }});
        public static final List<NumberWord> NumberWords = new ArrayList<NumberWord>(myCollection);

        private static final Map<Language, String> Negative =
                Collections.unmodifiableMap(new HashMap<Language, String>() {{
                    put(Language.English, "Negative");
                    put(Language.Persian, "منهای ");
                }});


        private static Map<Language, String> Zero =

                Collections.unmodifiableMap(new HashMap<Language, String>() {{
                    put(Language.English, "Zero");
                    put(Language.Persian, "صفر ");
                }});


        // Public Methods (5)

        /// <summary>
        /// display a numeric value using the equivalent text
        /// </summary>
        /// <param name="number">input number</param>
        /// <param name="language">local language</param>
        /// <returns>the equivalent text</returns>


        /// <summary>
        /// display a numeric value using the equivalent text
        /// </summary>
        /// <param name="number">input number</param>
        /// <param name="language">local language</param>
        /// <returns>the equivalent text</returns>
        public static String getNumberToText(int number, Language language) {
            return NumberToText((long) number, language);
        }

        /// <summary>
        /// display a numeric value using the equivalent text
        /// </summary>
        /// <param name="number">input number</param>
        /// <param name="language">local language</param>
        /// <returns>the equivalent text</returns>
        public static String getNumberToText(byte number, Language language) {
            return NumberToText((long) number, language);
        }

        /// <summary>
        /// display a numeric value using the equivalent text
        /// </summary>
        /// <param name="number">input number</param>
        /// <param name="language">local language</param>
        /// <returns>the equivalent text</returns>
        public static String getNumberToText(double number, Language language) {
            return NumberToText(number, language);
        }

        /// <summary>
        /// display a numeric value using the equivalent text
        /// </summary>
        /// <param name="number">input number</param>
        /// <param name="language">local language</param>
        /// <returns>the equivalent text</returns>


        /// <summary>
        /// display a numeric value using the equivalent text
        /// </summary>
        /// <param name="number">input number</param>
        /// <param name="language">local language</param>
        /// <returns>the equivalent text</returns>
        public static String NumberToText(double number, Language language) {
            if (number == 0) {
                return Zero.get(language);
            }

            if (number < 0) {
                return Negative.get(language) + NumberToText(-number, language);
            }

            return wordify(number, language, "", 0);
        }
        // Private Methods (2)

        private static String getName(int idx, Language language, DigitGroup group) {
            String s = "";
            for (NumberWord numberWord : NumberWords) {
                if (numberWord.getDigitalGroup().equals(group) && numberWord.getLanguage().equals(language)) {
                    s = numberWord.getNames().get(idx);
                    break;
                }
            }
            return s;

        }

        private static String wordify(double number, Language language, String leftDigitsText, int thousands) {
            if (number == 0) {
                return leftDigitsText;
            }

            String wordValue = leftDigitsText;
            if (wordValue.length() > 0) {
                wordValue += And.get(language);
            }

            if (number < 10) {
                wordValue += getName((int) number, language, DigitGroup.Ones);
            } else if (number < 20) {
                wordValue += getName((int) (number - 10), language, DigitGroup.Teens);
            } else if (number < 100) {
                wordValue += wordify(number % 10, language, getName((int) (number / 10 - 2), language, DigitGroup.Tens), 0);
            } else if (number < 1000) {
                wordValue += wordify(number % 100, language, getName((int) (number / 100), language, DigitGroup.Hundreds), 0);
            } else {
                wordValue += wordify(number % 1000, language, wordify(number / 1000, language, "", thousands + 1), 0);
            }

            if (number % 1000 == 0) return wordValue;
            return wordValue + getName(thousands, language, DigitGroup.Thousands);
        }


    }


    public static class EnglishNumberToWords {

        private static final String[] tensNames = {
                "",
                " ten",
                " twenty",
                " thirty",
                " forty",
                " fifty",
                " sixty",
                " seventy",
                " eighty",
                " ninety"
        };

        private static final String[] numNames = {
                "",
                " one",
                " two",
                " three",
                " four",
                " five",
                " six",
                " seven",
                " eight",
                " nine",
                " ten",
                " eleven",
                " twelve",
                " thirteen",
                " fourteen",
                " fifteen",
                " sixteen",
                " seventeen",
                " eighteen",
                " nineteen"
        };

        private EnglishNumberToWords() {
        }

        private static String convertLessThanOneThousand(int number) {
            String soFar;

            if (number % 100 < 20) {
                soFar = numNames[number % 100];
                number /= 100;
            } else {
                soFar = numNames[number % 10];
                number /= 10;

                soFar = tensNames[number % 10] + soFar;
                number /= 10;
            }
            if (number == 0) return soFar;
            return numNames[number] + " hundred" + soFar;
        }

        public static String convert(long number) {
            // 0 to 999 999 999 999
            if (number == 0) {
                return "zero";
            }

            String snumber = Long.toString(number);

            // pad with "0"
            String mask = "000000000000";
            DecimalFormat df = new DecimalFormat(mask);
            snumber = df.format(number);

            // XXXnnnnnnnnn
            int billions = Integer.parseInt(snumber.substring(0, 3));
            // nnnXXXnnnnnn
            int millions = Integer.parseInt(snumber.substring(3, 6));
            // nnnnnnXXXnnn
            int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
            // nnnnnnnnnXXX
            int thousands = Integer.parseInt(snumber.substring(9, 12));

            String tradBillions;
            switch (billions) {
                case 0:
                    tradBillions = "";
                    break;
                case 1:
                    tradBillions = convertLessThanOneThousand(billions)
                            + " billion ";
                    break;
                default:
                    tradBillions = convertLessThanOneThousand(billions)
                            + " billion ";
            }
            String result = tradBillions;

            String tradMillions;
            switch (millions) {
                case 0:
                    tradMillions = "";
                    break;
                case 1:
                    tradMillions = convertLessThanOneThousand(millions)
                            + " million ";
                    break;
                default:
                    tradMillions = convertLessThanOneThousand(millions)
                            + " million ";
            }
            result = result + tradMillions;

            String tradHundredThousands;
            switch (hundredThousands) {
                case 0:
                    tradHundredThousands = "";
                    break;
                case 1:
                    tradHundredThousands = "one thousand ";
                    break;
                default:
                    tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                            + " thousand ";
            }
            result = result + tradHundredThousands;

            String tradThousand;
            tradThousand = convertLessThanOneThousand(thousands);
            result = result + tradThousand;

            // remove extra spaces!
            return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
        }
    }

    public static class BigNumberToWords {
        public static NumberResult getWordsFromNumber(int number) {
            NumberResult result=new NumberResult();
            if (number <= 0) {
                result.setValueAsNumber(0);
                result.setValueAsString("صفر");
            }

            else if (number <= 10) {

                result.setValueAsNumber(number*1000000);
                result.setValueAsString(number+" میلیون ");
            } else if (number <= 19) {
                int i =  number - 10;
                i++;
                i*=10;

                result.setValueAsNumber(i*1000000);
                result.setValueAsString(i+" میلیون ");
            } else if (number <= 27) {
                int i =  number - 19;
                i++;
                i*=100;

                result.setValueAsNumber(i*1000000);
                result.setValueAsString(i+" میلیون ");
            } else if (number <= 38) {
                int i =  number - 28;
                i++;
                result.setValueAsNumber(i*1000000000);
                result.setValueAsString(i+" میلیارد ");
            }
            return result;
        }

        public static double getRealmNumber(int number) {
            double realNumber = -1d;
            if (number < 10) {
                realNumber = number * 1000000d;

            } else if (number < 20) {
                int i = number - 10;
                realNumber = i * 10000000d;
            } else if (number < 30) {
                int i = number - 20;
                realNumber = i * 100000000d;
            } else if (number < 40) {
                int i = number - 30;
                realNumber = i * 100000000d;
            }
            return realNumber;
        }

        public static class NumberResult{
            private double valueAsNumber;
            private String valueAsString;

            public double getValueAsNumber() {
                return valueAsNumber;
            }

            public void setValueAsNumber(double valueAsNumber) {
                this.valueAsNumber = valueAsNumber;
            }

            public String getValueAsString() {
                return valueAsString;
            }

            public void setValueAsString(String valueAsString) {
                this.valueAsString = valueAsString;
            }
        }
    }

}
