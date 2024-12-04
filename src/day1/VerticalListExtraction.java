package day1;

import java.util.ArrayList;
import java.util.List;

public class VerticalListExtraction {
    public static void main(String[] args) {
        String inputString = "37033   48086\n80098   34930\n88073   69183\n54342   63061\n98409   87908\n81400   96222\n42062   53621\n55208   48086\n10847   20622\n53237   11766\n12609   19507\n31524   33054\n83455   96879\n53344   76641\n94982   66380\n69183   70224\n35580   12846\n87598   24335\n82193   11774\n69512   57198\n59322   57031\n68842   58244\n44042   39233\n16249   57139\n85264   31175\n10891   68793\n40085   98617\n91566   98409\n87478   49199\n39821   33343\n74610   62695\n68536   31524\n68470   52968\n49918   78866\n22935   44471\n76024   92757\n65243   98409\n93508   26529\n89938   19767\n74104   28327\n95395   51124\n57361   30769\n17053   38420\n89386   27077\n66052   49634\n31107   86173\n20356   70681\n32859   77448\n61081   68078\n66997   11420\n47491   52799\n52909   18865\n98231   14451\n78232   81629\n13844   65959\n42821   44935\n42441   17048\n43148   63037\n64953   17930\n94799   43046\n36346   50323\n62122   36926\n12807   35501\n62695   49155\n70681   87913\n44566   67881\n84508   75693\n53457   53621\n81188   75898\n18550   78193\n78314   72664\n28118   75012\n55363   82133\n55936   96958\n71769   62301\n64882   55809\n22070   52069\n80402   18865\n87887   59381\n19262   90572\n85007   46788\n36926   95926\n19398   39233\n38479   40232\n32794   85776\n82010   48505\n44551   59594\n52215   96042\n47295   62695\n23560   64868\n41516   29134\n78567   96879\n56100   44280\n37923   53621\n23366   20622\n88384   38143\n32427   93236\n28815   77641\n64098   70832\n63820   52069\n65685   41926\n77989   34282\n19213   73228\n90916   59042\n34392   59594\n53405   20622\n61530   85362\n67067   58244\n15915   52074\n84869   45493\n16808   52099\n83066   30481\n60279   34507\n18216   69308\n43386   89121\n48876   20622\n81226   81863\n13439   96879\n33538   20803\n57046   57031\n97890   31524\n49650   81758\n83353   53621\n97124   11654\n42320   55708\n15216   67981\n41159   54382\n23511   59594\n69428   62695\n75545   54382\n40455   50323\n14796   17517\n64841   54382\n45297   98409\n85055   15951\n54382   89121\n75123   48014\n77380   73118\n89593   29398\n65102   84571\n29684   50323\n78501   98409\n22658   48086\n69048   37242\n78675   43046\n42018   64394\n20090   98409\n73590   59594\n77407   70588\n54617   60692\n31801   30470\n94282   59594\n23846   84393\n80158   75833\n41973   18865\n10733   72754\n21476   89327\n53199   42757\n57875   22438\n80198   27009\n78998   36146\n46245   29134\n50181   37209\n65481   89603\n11531   16038\n33594   38324\n57846   75210\n92753   46215\n16725   78130\n67071   32249\n58481   81278\n79423   50340\n97039   64868\n87562   54382\n43046   90102\n39144   51352\n59594   15951\n84863   15951\n17517   18865\n49574   65630\n32557   63961\n46236   13439\n97729   58376\n71110   50323\n96590   53621\n94510   30481\n71029   34573\n86457   21887\n28954   17350\n35852   31524\n93863   39233\n47572   73683\n97380   18865\n30754   30481\n60704   89447\n92001   69183\n32801   66142\n81487   31524\n18073   52639\n35906   59208\n43812   17762\n98364   54382\n63099   93285\n23874   11420\n23929   15951\n63965   58244\n13509   50297\n67586   72452\n38100   76429\n57896   36516\n31621   59594\n68378   13399\n98229   89945\n37332   42762\n39317   13399\n29751   70681\n23350   49329\n94426   54530\n51125   98409\n13568   25793\n40634   93771\n76318   20622\n56797   62352\n77125   92452\n92723   78193\n52702   97941\n71042   48086\n75241   48086\n82106   86471\n43549   51785\n57031   93563\n45097   85133\n39233   38284\n44072   23577\n78219   48086\n10218   75355\n34441   52069\n27486   64929\n94555   15951\n36126   33020\n50417   20622\n97392   18353\n59162   90002\n43315   19287\n28705   67881\n29116   18865\n54164   39121\n41481   91282\n81138   85776\n85885   67495\n96203   95531\n11050   37542\n12902   95734\n23499   10033\n86109   18865\n13588   75493\n11234   42933\n58393   31524\n74806   69463\n81423   40663\n56077   58244\n55377   18865\n19426   52069\n46626   54382\n37701   33145\n57512   74160\n27195   70681\n14778   22306\n24054   25503\n23289   29807\n37933   36926\n61780   11400\n50323   83188\n33579   91321\n63956   13439\n99407   96879\n91416   76077\n88001   95578\n62066   33499\n24116   98790\n47745   19497\n64915   31524\n15961   93427\n68594   81210\n34351   59202\n40327   98303\n72705   67448\n12525   23334\n43151   82488\n35068   49777\n68599   69183\n94043   78193\n13678   98199\n81582   69183\n73934   36346\n55739   43046\n85642   75087\n91889   62893\n67778   92891\n35695   73450\n55718   78193\n63959   34907\n38017   98409\n66723   17517\n74248   43974\n88967   64011\n83130   20258\n99204   59594\n70476   66058\n61286   50220\n48510   31524\n79991   38603\n19872   59594\n87662   98303\n19340   52069\n43964   15951\n90112   80030\n43191   15951\n98554   72878\n21344   54382\n19604   98409\n33237   10812\n51468   40519\n38791   85794\n74239   29333\n66680   95424\n24080   97635\n90972   18626\n87429   97643\n91221   28641\n72127   62326\n24113   72380\n81008   23132\n99596   15951\n33037   17517\n90429   94990\n95722   78709\n44529   11954\n40869   74940\n85270   98409\n61916   88339\n94503   31524\n57636   10919\n34500   53621\n67881   27216\n93866   48086\n95505   41472\n60258   13439\n73971   96879\n78155   84381\n52246   30293\n42752   11420\n91033   69183\n91316   64187\n99667   30481\n26343   66657\n47584   85776\n88747   93445\n48170   29134\n82355   98303\n72601   67372\n59362   16525\n23719   70681\n73439   89676\n41361   45165\n91378   13419\n23936   33954\n98014   13399\n15650   65042\n64527   77524\n57963   13032\n24657   39982\n71342   37777\n48315   75222\n54519   66142\n76974   53621\n85608   27055\n20837   93663\n54927   24425\n13139   20622\n15005   11420\n84490   76060\n89171   70473\n17832   96879\n18470   54382\n45260   83667\n17276   27108\n52681   32349\n61355   13439\n47525   11420\n36905   70681\n59209   75250\n95591   47770\n14642   68650\n40203   73611\n52858   61463\n48675   42759\n98405   64868\n80951   82870\n53621   79358\n25327   78193\n87475   48086\n51819   24117\n27015   17111\n98465   66142\n72427   73936\n71733   96879\n89121   60064\n22901   30122\n10856   48527\n36754   64868\n50122   50538\n52355   73026\n40825   40951\n80386   16069\n83603   36182\n58594   13717\n31497   71550\n40053   48086\n38188   39233\n18994   96329\n79861   50323\n23321   85776\n61404   10062\n95531   53621\n34909   98952\n23995   93754\n13871   98442\n54796   30148\n35319   93955\n64282   26287\n83133   82959\n56071   47244\n67009   47394\n92507   47341\n85776   46164\n30709   57965\n59236   35175\n20724   66427\n33428   94891\n11751   44280\n36923   59594\n76810   42646\n35667   96679\n42268   98409\n57684   38466\n40804   66142\n76968   66990\n99714   52069\n57148   28084\n16707   54930\n16915   32950\n18508   45796\n84647   62099\n24717   15951\n97165   52069\n88312   54080\n44527   62695\n13285   75521\n15532   45721\n83771   98303\n69300   69450\n33929   98294\n63656   85776\n58244   89121\n98243   65914\n79896   43809\n61035   98303\n66387   66433\n35297   91503\n60092   18889\n93026   91504\n73054   33258\n64475   70681\n54041   12197\n23521   20243\n91854   58244\n95611   62695\n70144   14591\n46105   93466\n13551   22559\n98318   32023\n72900   96879\n17675   99283\n21850   56050\n50581   44825\n49017   89297\n26268   73032\n76642   24749\n57925   72795\n63723   27403\n32025   20622\n15951   48086\n85672   58244\n24553   57031\n49464   62695\n67767   85776\n58337   85776\n74953   59594\n69307   20622\n54291   39233\n52996   15951\n65777   98303\n66534   75432\n23911   73020\n35599   53621\n80629   79286\n59328   98303\n88093   18865\n25517   18865\n19457   58244\n12955   55118\n90990   19917\n45463   45747\n77714   64511\n56882   42004\n25038   31524\n85217   20622\n99959   36346\n79460   26413\n86151   41237\n48086   30398\n31177   36926\n15315   83228\n73930   58503\n31633   37808\n25732   52462\n72722   22108\n21950   54382\n32065   92741\n45641   26363\n97024   96879\n44240   57089\n59276   20622\n42165   57163\n72746   70681\n70771   36926\n38232   78721\n71104   91763\n93422   84268\n82725   93116\n38739   25006\n93983   67881\n66261   37918\n45318   60554\n29927   61543\n75323   14960\n76535   13439\n95437   57747\n70363   58272\n79957   15661\n67064   32990\n20092   96879\n12567   69183\n52045   86433\n56000   76650\n72348   62567\n68077   58244\n51346   64868\n90427   68815\n55238   84016\n63141   23115\n44187   48086\n73242   46883\n37067   74850\n22831   78193\n33348   54605\n36004   75163\n69742   62695\n97982   85776\n81147   69183\n30121   44534\n89460   70312\n65414   48502\n41797   70681\n97715   59594\n11895   62739\n53566   36346\n88592   13685\n44867   18865\n38494   93238\n90302   57031\n29959   77575\n14477   64868\n95081   94031\n80618   98409\n31630   59639\n11480   15771\n57197   12243\n69484   97473\n15324   54382\n85375   28233\n70310   39233\n29134   66142\n17677   70681\n10533   50323\n32670   13399\n65046   89121\n27250   57826\n50565   18865\n10750   15951\n86359   36926\n17412   20622\n56284   58734\n24630   32786\n51890   31524\n62891   15178\n90991   54171\n18599   35575\n18865   35025\n26344   13399\n18002   85776\n61277   96879\n37141   57031\n86471   75319\n55111   37439\n41036   72230\n57319   96257\n44621   10761\n63452   89121\n64428   44023\n94409   64868\n97533   68365\n44422   53621\n82027   13439\n12954   54919\n47142   25744\n85528   66521\n81778   62695\n67727   32777\n66391   39630\n24686   62695\n81899   59594\n23924   99354\n28401   50030\n25839   98409\n80138   30520\n54999   14824\n93520   54172\n75113   64190\n60779   18923\n10355   41820\n32709   20332\n54938   70681\n49081   57031\n59825   82761\n38481   66142\n17642   85776\n93320   64868\n86185   89121\n90785   20622\n78441   70270\n15058   58554\n13159   99885\n71048   82807\n18657   62823\n25375   54382\n86493   57461\n68185   49281\n36666   48086\n57255   76149\n69221   70681\n13455   45466\n44124   44225\n12571   79912\n22123   18865\n41374   19055\n14066   88458\n42576   53164\n54786   71358\n48734   32761\n72366   76013\n38118   52069\n28516   98303\n84839   92356\n33967   51873\n39686   42909\n97775   58244\n97891   20622\n95436   31524\n40160   26365\n45663   83105\n73959   62695\n83007   21673\n34716   18865\n42940   60190\n30448   98303\n54016   56062\n98158   11420\n76233   67511\n71248   14271\n33181   52757\n73295   59594\n42588   69183\n28020   18683\n65760   13399\n51626   35859\n23978   66142\n26564   53338\n34634   15951\n47149   30575\n28625   20989\n78780   85370\n98473   26689\n66142   58244\n37914   48086\n91597   96879\n42550   89165\n79970   74953\n73019   69183\n21908   27351\n96153   79995\n58843   53621\n91807   12526\n92395   71081\n21579   48086\n79524   98282\n34060   85776\n27571   41575\n62300   37578\n88423   72261\n66840   95531\n39956   44045\n77892   67881\n10204   80385\n55417   42304\n34672   18865\n40908   48086\n97799   20148\n25065   53621\n62503   98409\n96437   67881\n74378   31222\n61972   70681\n89255   70681\n80855   18865\n54885   38371\n64050   15556\n21358   10464\n25723   92679\n95201   53621\n61421   49146\n86050   89893\n93226   78113\n42266   75153\n11881   17646\n69987   30481\n71028   85327\n24743   32122\n48190   85312\n45256   64868\n19567   11420\n89596   50323\n49101   86202\n68965   39233\n50874   13439\n17159   24728\n50369   35203\n78343   56136\n55351   73651\n48074   59594\n11532   42633\n82644   92794\n95771   34677\n59150   28294\n38484   64868\n48890   64382\n68966   28298\n51394   66142\n69899   91877\n20622   27299\n47091   19931\n81236   72834\n78009   41686\n48131   52069\n34760   83087\n54872   88748\n99903   44280\n75164   77528\n98303   81353\n89179   47262\n93330   85776\n64653   62695\n75680   59594\n28615   46658\n24345   58244\n79606   36346\n48948   97944\n98505   89997\n56392   90073\n76055   90144\n82417   29331\n62098   20173\n17254   59594\n48731   89213\n91622   10612\n96177   62695\n52069   59594\n13399   98409\n32967   62695\n80796   97619\n77193   28072\n55904   13399\n84250   81410\n53217   64868\n10500   80320\n67277   53621\n72249   93147\n65047   54902\n17107   63592\n76194   12779\n27559   83996\n79679   50585\n61580   69975\n65266   31524\n88473   84465\n79876   62695\n65441   16454\n80352   69183\n82496   39233\n52114   67176\n51220   91015\n50000   53335\n42335   68722\n53404   43046\n99871   66142\n32080   89121\n31786   17440\n92788   21713\n56249   44735\n61367   48207\n62686   18865\n96072   82701\n20243   17083\n12117   35213\n19815   26817\n79102   94396\n44142   48396\n69916   20622\n55931   67881\n31342   63716\n39653   62400\n77941   81859\n11114   80231\n52176   70681\n57866   95927\n16866   98409\n58810   52495\n30481   13399\n47222   62695\n44280   37037\n14384   62695\n87330   99383\n36889   98303\n87970   58244\n53739   41685\n40509   84262\n87526   11810\n34019   89121\n66761   29134\n82984   80221\n83300   43046\n31073   13399\n38528   10345\n42647   69040\n78499   66142\n65835   13399\n11888   52069\n16021   52069\n77506   18865\n37718   48194\n30087   28445\n11104   52070\n16603   52069\n32201   52069\n80129   87617\n30931   20174\n55331   36346\n88876   58551\n78652   57031\n81997   26780\n44346   20622\n31652   15430\n97390   65924\n84105   42911\n51646   52069\n73632   39233\n22774   58432\n67720   10485\n94677   22142\n15291   23118\n97553   91441\n13036   16132\n66370   89121\n47010   64499\n14579   36926\n71383   38714\n36373   44545\n80180   48086\n30591   52069\n90029   94693\n99057   45433\n96879   59594\n30934   96879\n40909   64001\n83174   44065\n99020   88105\n11420   41090\n52834   64349\n29417   40615\n23216   84918\n61489   62695\n69615   63436\n64767   37178\n28368   31524\n29166   83509\n88181   26952\n92376   46034\n56924   13399\n16465   18865\n29356   68035\n54993   36926\n18295   67097\n82237   43901\n78347   15951\n31212   15951\n36998   54208\n72196   14327\n10596   59594\n40421   66142\n10375   71778\n53059   29196\n33476   68714\n88721   27093\n82358   83161\n45486   51031\n61135   70681\n25501   16321\n12221   62619\n98976   89121\n83483   36480\n24673   41710\n36211   39233\n65135   61232\n64780   43227\n80301   70681\n45462   68721\n67491   81035\n79555   81549\n58586   95531\n52960   12428\n49575   44280\n65496   13439\n66682   98303\n93266   13399\n30310   69183\n21871   50286\n53042   52803\n22862   21603\n78193   85776\n87258   87131\n76615   84237\n88433   86471\n11880   74358\n27516   54382\n90874   52601\n95239   98303\n35641   18223\n93150   13439\n23926   14395\n68954   80564\n67708   28415\n54348   11420\n32006   70313\n89793   59594\n47625   20243\n42304   15951\n48069   91705\n44492   92921\n18981   42304\n13501   71398\n64868   18580\n38280   87499\n40480   96879\n76161   87470\n53440   26034\n99706   54382\n22102   95972\n23433   56267\n70986   83482\n49356   98303\n25792   48432\n87046   20622\n44220   54382\n19076   22755\n66811   96311\n90099   15951\n33595   70999\n19173   20622\n12964   56430".formatted();

        String[] lines = inputString.split("\n");
        List<List<Integer>> inputLists = new ArrayList<>();
        for (String line : lines) {
            System.out.println(line + "___");
            String[] numbers = line.trim().split("\\s+");
            List<Integer> row = new ArrayList<>();
            for (String number : numbers) {
                row.add(Integer.parseInt(number));
            }
            inputLists.add(row);
        }

        int numRows = inputLists.size();
        int numCols = inputLists.get(0).size();

        List<List<Integer>> verticalLists = new ArrayList<>();
        for (int col = 0; col < numCols; col++) {
            List<Integer> verticalList = new ArrayList<>();
            for (int row = 0; row < numRows; row++) {
                verticalList.add(inputLists.get(row).get(col));
            }
            verticalLists.add(verticalList);
        }

        // Print the vertical lists
        for (List<Integer> verticalList : verticalLists) {
            System.out.println(verticalList);
        }
    }
}