import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    final static int FILE_COUNT = 392;

    final static HashMap<Integer, String> filenameID = new HashMap<Integer, String>() {{
        put(0, "AccordianFold.ms3d");
        put(1, "AccordianKeyBlack.ms3d");
        put(2, "AccordianKeyWhiteBack.ms3d");
        put(3, "AccordianKeyWhiteFront.ms3d");
        put(4, "AccordianLeftHand.ms3d");
        put(5, "AccordianRightHand.ms3d");
        put(6, "Agogo.ms3d");
        put(7, "AgogoSingle.ms3d");
        put(8, "AltoSaxBody.ms3d");
        put(9, "AltoSaxHorn.ms3d");
        put(10, "AltoSaxKeyDown0.ms3d");
        put(11, "AltoSaxKeyDown1.ms3d");
        put(12, "AltoSaxKeyDown10.ms3d");
        put(13, "AltoSaxKeyDown11.ms3d");
        put(14, "AltoSaxKeyDown12.ms3d");
        put(15, "AltoSaxKeyDown13.ms3d");
        put(16, "AltoSaxKeyDown14.ms3d");
        put(17, "AltoSaxKeyDown15.ms3d");
        put(18, "AltoSaxKeyDown16.ms3d");
        put(19, "AltoSaxKeyDown17.ms3d");
        put(20, "AltoSaxKeyDown18.ms3d");
        put(21, "AltoSaxKeyDown19.ms3d");
        put(22, "AltoSaxKeyDown2.ms3d");
        put(23, "AltoSaxKeyDown3.ms3d");
        put(24, "AltoSaxKeyDown4.ms3d");
        put(25, "AltoSaxKeyDown5.ms3d");
        put(26, "AltoSaxKeyDown6.ms3d");
        put(27, "AltoSaxKeyDown7.ms3d");
        put(28, "AltoSaxKeyDown8.ms3d");
        put(29, "AltoSaxKeyDown9.ms3d");
        put(30, "AltoSaxKeyUp0.ms3d");
        put(31, "AltoSaxKeyUp1.ms3d");
        put(32, "AltoSaxKeyUp10.ms3d");
        put(33, "AltoSaxKeyUp11.ms3d");
        put(34, "AltoSaxKeyUp12.ms3d");
        put(35, "AltoSaxKeyUp13.ms3d");
        put(36, "AltoSaxKeyUp14.ms3d");
        put(37, "AltoSaxKeyUp15.ms3d");
        put(38, "AltoSaxKeyUp16.ms3d");
        put(39, "AltoSaxKeyUp17.ms3d");
        put(40, "AltoSaxKeyUp18.ms3d");
        put(41, "AltoSaxKeyUp19.ms3d");
        put(42, "AltoSaxKeyUp2.ms3d");
        put(43, "AltoSaxKeyUp3.ms3d");
        put(44, "AltoSaxKeyUp4.ms3d");
        put(45, "AltoSaxKeyUp5.ms3d");
        put(46, "AltoSaxKeyUp6.ms3d");
        put(47, "AltoSaxKeyUp7.ms3d");
        put(48, "AltoSaxKeyUp8.ms3d");
        put(49, "AltoSaxKeyUp9.ms3d");
        put(50, "BaritoneSaxBody.ms3d");
        put(51, "BaritoneSaxHorn.ms3d");
        put(52, "Bass.ms3d");
        put(53, "BassNoteFinger.ms3d");
        put(54, "BassShadow.ms3d");
        put(55, "BassString.ms3d");
        put(56, "BassStringBottom0.ms3d");
        put(57, "BassStringBottom1.ms3d");
        put(58, "BassStringBottom2.ms3d");
        put(59, "BassStringBottom3.ms3d");
        put(60, "BassStringBottom4.ms3d");
        put(61, "cabasa.ms3d");
        put(62, "Castanets.ms3d");
        put(63, "Cello.ms3d");
        put(64, "clave.ms3d");
        put(65, "CowBell.ms3d");
        put(66, "DoubleBass.ms3d");
        put(67, "DrumSet_BassDrum.ms3d");
        put(68, "DrumSet_BassDrumBeaterArm.ms3d");
        put(69, "DrumSet_BassDrumBeaterHolder.ms3d");
        put(70, "DrumSet_BassDrumPedal.ms3d");
        put(71, "DrumSet_Bongo.ms3d");
        put(72, "DrumSet_ChinaCymbal.ms3d");
        put(73, "DrumSet_Conga.ms3d");
        put(74, "DrumSet_Cymbal.ms3d");
        put(75, "DrumSet_SnareDrum.ms3d");
        put(76, "DrumSet_Stick.ms3d");
        put(77, "DrumSet_Timbale.ms3d");
        put(78, "DrumSet_Tom.ms3d");
        put(79, "DrumShadow.ms3d");
        put(80, "Flute.ms3d");
        put(81, "Flute_LeftHand00.ms3d");
        put(82, "Flute_LeftHand01.ms3d");
        put(83, "Flute_LeftHand02.ms3d");
        put(84, "Flute_LeftHand03.ms3d");
        put(85, "Flute_LeftHand04.ms3d");
        put(86, "Flute_LeftHand05.ms3d");
        put(87, "Flute_LeftHand06.ms3d");
        put(88, "Flute_LeftHand07.ms3d");
        put(89, "Flute_LeftHand08.ms3d");
        put(90, "Flute_LeftHand09.ms3d");
        put(91, "Flute_LeftHand10.ms3d");
        put(92, "Flute_LeftHand11.ms3d");
        put(93, "Flute_LeftHand12.ms3d");
        put(94, "Flute_RightHand00.ms3d");
        put(95, "Flute_RightHand01.ms3d");
        put(96, "Flute_RightHand02.ms3d");
        put(97, "Flute_RightHand03.ms3d");
        put(98, "Flute_RightHand04.ms3d");
        put(99, "Flute_RightHand05.ms3d");
        put(100, "Flute_RightHand06.ms3d");
        put(101, "Flute_RightHand07.ms3d");
        put(102, "Flute_RightHand08.ms3d");
        put(103, "Flute_RightHand09.ms3d");
        put(104, "Flute_RightHand10.ms3d");
        put(105, "Flute_RightHand11.ms3d");
        put(106, "FrenchHornBody.ms3d");
        put(107, "FrenchHornHorn.ms3d");
        put(108, "FrenchHornKey1.ms3d");
        put(109, "FrenchHornKey2.ms3d");
        put(110, "FrenchHornKey3.ms3d");
        put(111, "FrenchHornTrigger.ms3d");
        put(112, "Guitar.ms3d");
        put(113, "GuitarHighStringBottom0.ms3d");
        put(114, "GuitarHighStringBottom1.ms3d");
        put(115, "GuitarHighStringBottom2.ms3d");
        put(116, "GuitarHighStringBottom3.ms3d");
        put(117, "GuitarHighStringBottom4.ms3d");
        put(118, "GuitarLowStringBottom0.ms3d");
        put(119, "GuitarLowStringBottom1.ms3d");
        put(120, "GuitarLowStringBottom2.ms3d");
        put(121, "GuitarLowStringBottom3.ms3d");
        put(122, "GuitarLowStringBottom4.ms3d");
        put(123, "GuitarNoteFinger.ms3d");
        put(124, "GuitarShadow.ms3d");
        put(125, "GuitarStringHigh.ms3d");
        put(126, "GuitarStringLow.ms3d");
        put(127, "hand_left.ms3d");
        put(128, "hand_right.ms3d");
        put(129, "hand_tamborine.ms3d");
        put(130, "Harmonica.ms3d");
        put(131, "Harp.ms3d");
        put(132, "HarpShadow.ms3d");
        put(133, "HarpString.ms3d");
        put(134, "HarpStringPlaying0.ms3d");
        put(135, "HarpStringPlaying1.ms3d");
        put(136, "HarpStringPlaying2.ms3d");
        put(137, "HarpStringPlaying3.ms3d");
        put(138, "HarpStringPlaying4.ms3d");
        put(139, "JingleBells.ms3d");
        put(140, "MalletHitShadow.ms3d");
        put(141, "maraca.ms3d");
        put(142, "MelodicTom.ms3d");
        put(143, "MetronomeBox.ms3d");
        put(144, "MetronomePendjulum1.ms3d");
        put(145, "MetronomePendjulum2.ms3d");
        put(146, "MusicBoxCase.ms3d");
        put(147, "MusicBoxKey.ms3d");
        put(148, "MusicBoxPoint.ms3d");
        put(149, "MusicBoxSpindle.ms3d");
        put(150, "MusicBoxTopBlade.ms3d");
        put(151, "MutedTriangle.ms3d");
        put(152, "Ocarina.ms3d");
        put(153, "OcarinaHand0.ms3d");
        put(154, "OcarinaHand1.ms3d");
        put(155, "OcarinaHand10.ms3d");
        put(156, "OcarinaHand11.ms3d");
        put(157, "OcarinaHand2.ms3d");
        put(158, "OcarinaHand3.ms3d");
        put(159, "OcarinaHand4.ms3d");
        put(160, "OcarinaHand5.ms3d");
        put(161, "OcarinaHand6.ms3d");
        put(162, "OcarinaHand7.ms3d");
        put(163, "OcarinaHand8.ms3d");
        put(164, "OcarinaHand9.ms3d");
        put(165, "PanPipe.ms3d");
        put(166, "PianoCase.ms3d");
        put(167, "PianoKeyBlack.ms3d");
        put(168, "PianoKeyBlackDown.ms3d");
        put(169, "PianoKeyWhiteBack.ms3d");
        put(170, "PianoKeyWhiteBackDown.ms3d");
        put(171, "PianoKeyWhiteFront.ms3d");
        put(172, "PianoKeyWhiteFrontDown.ms3d");
        put(173, "PianoShadow.ms3d");
        put(174, "PianoStand.ms3d");
        put(175, "Piccolo.ms3d");
        put(176, "PizzicatoStringHolder.ms3d");
        put(177, "PopBottle.ms3d");
        put(178, "PopBottleLabel.ms3d");
        put(179, "PopBottleMiddle.ms3d");
        put(180, "PopBottlePop.ms3d");
        put(181, "Recorder.ms3d");
        put(182, "RecorderHandLeft0.ms3d");
        put(183, "RecorderHandLeft1.ms3d");
        put(184, "RecorderHandLeft10.ms3d");
        put(185, "RecorderHandLeft11.ms3d");
        put(186, "RecorderHandLeft12.ms3d");
        put(187, "RecorderHandLeft2.ms3d");
        put(188, "RecorderHandLeft3.ms3d");
        put(189, "RecorderHandLeft4.ms3d");
        put(190, "RecorderHandLeft5.ms3d");
        put(191, "RecorderHandLeft6.ms3d");
        put(192, "RecorderHandLeft7.ms3d");
        put(193, "RecorderHandLeft8.ms3d");
        put(194, "RecorderHandLeft9.ms3d");
        put(195, "RecorderHandRight0.ms3d");
        put(196, "RecorderHandRight1.ms3d");
        put(197, "RecorderHandRight10.ms3d");
        put(198, "RecorderHandRight2.ms3d");
        put(199, "RecorderHandRight3.ms3d");
        put(200, "RecorderHandRight4.ms3d");
        put(201, "RecorderHandRight5.ms3d");
        put(202, "RecorderHandRight6.ms3d");
        put(203, "RecorderHandRight7.ms3d");
        put(204, "RecorderHandRight8.ms3d");
        put(205, "RecorderHandRight9.ms3d");
        put(206, "SapranoSaxBody.ms3d");
        put(207, "SapranoSaxHorn.ms3d");
        put(208, "SaxBottom.ms3d");
        put(209, "ScreenGradient.ms3d");
        put(210, "Shaker.ms3d");
        put(211, "SongFillbar.ms3d");
        put(212, "SongFillbarBox.ms3d");
        put(213, "SquareShaker.ms3d");
        put(214, "Stage.ms3d");
        put(215, "StageChoir.ms3d");
        put(216, "StageHorn.ms3d");
        put(217, "StageString.ms3d");
        put(218, "StageStringBottom0.ms3d");
        put(219, "StageStringBottom1.ms3d");
        put(220, "StageStringBottom2.ms3d");
        put(221, "StageStringBottom3.ms3d");
        put(222, "StageStringBottom4.ms3d");
        put(223, "StageStringBow.ms3d");
        put(224, "StageStringHolder.ms3d");
        put(225, "SteamCloud.ms3d");
        put(226, "SteelDrum.ms3d");
        put(227, "SteelDrumMallet.ms3d");
        put(228, "SynthDrum.ms3d");
        put(229, "Taiko.ms3d");
        put(230, "TaikoStick.ms3d");
        put(231, "TelePhoneBase.ms3d");
        put(232, "TelePhoneHandle.ms3d");
        put(233, "TelePhoneKey.ms3d");
        put(234, "TenorSaxBody.ms3d");
        put(235, "TenorSaxHorn.ms3d");
        put(236, "TimpaniBody.ms3d");
        put(237, "TimpaniHead.ms3d");
        put(238, "Triangle.ms3d");
        put(239, "Triangle_Stick.ms3d");
        put(240, "Trombone.ms3d");
        put(241, "TromboneSlide.ms3d");
        put(242, "TrumpetBody.ms3d");
        put(243, "TrumpetHorn.ms3d");
        put(244, "TrumpetKey1.ms3d");
        put(245, "TrumpetKey2.ms3d");
        put(246, "TrumpetKey3.ms3d");
        put(247, "TrumpetMute.ms3d");
        put(248, "TubaBody.ms3d");
        put(249, "TubaHorn.ms3d");
        put(250, "TubaKey1.ms3d");
        put(251, "TubaKey2.ms3d");
        put(252, "TubaKey3.ms3d");
        put(253, "TubaKey4.ms3d");
        put(254, "TubularBell.ms3d");
        put(255, "TubularBellDark.ms3d");
        put(256, "TubularBellMallet.ms3d");
        put(257, "Violin.ms3d");
        put(258, "ViolinBow.ms3d");
        put(259, "ViolinFinger.ms3d");
        put(260, "ViolinString.ms3d");
        put(261, "ViolinStringPlayed0.ms3d");
        put(262, "ViolinStringPlayed1.ms3d");
        put(263, "ViolinStringPlayed2.ms3d");
        put(264, "ViolinStringPlayed3.ms3d");
        put(265, "ViolinStringPlayed4.ms3d");
        put(266, "Whistle.ms3d");
        put(267, "WoodBlockHigh.ms3d");
        put(268, "WoodBlockLow.ms3d");
        put(269, "WoodBlockSingle.ms3d");
        put(270, "XylophoneBlackBar.ms3d");
        put(271, "XylophoneBlackBarDown.ms3d");
        put(272, "XylophoneCase.ms3d");
        put(273, "XylophoneLegs.ms3d");
        put(274, "XylophoneMalletWhite.ms3d");
        put(275, "XylophoneShadow.ms3d");
        put(276, "XylophoneWhiteBar.ms3d");
        put(277, "XylophoneWhiteBarDown.ms3d");
        put(278, "Zapper.ms3d");
        put(279, "ZapperLaser.ms3d");
        put(280, "AccordianCase.bmp");
        put(281, "AccordianCaseFront.bmp");
        put(282, "AccordianFold.bmp");
        put(283, "AccordianKey.bmp");
        put(284, "AccordianKeyBlack.bmp");
        put(285, "AccordianKeyBlackDown.bmp");
        put(286, "AccordianKeyDown.bmp");
        put(287, "BassShadow.bmp");
        put(288, "BassSkin.bmp");
        put(289, "Black.bmp");
        put(290, "cabasa.bmp");
        put(291, "CelloSkin.bmp");
        put(292, "ChoirPeep.bmp");
        put(293, "Clave.bmp");
        put(294, "CymbalSkinSphereMap.bmp");
        put(295, "DarkWood.bmp");
        put(296, "DoubleBassSkin.bmp");
        put(297, "DrumShadow.bmp");
        put(298, "DrumShell.bmp");
        put(299, "DrumShell_Bongo.bmp");
        put(300, "DrumShell_Conga.bmp");
        put(301, "DrumShell_MelodicTom.bmp");
        put(302, "DrumShell_Snare.bmp");
        put(303, "DrumShell_Timbale.bmp");
        put(304, "FakeWood.bmp");
        put(305, "Font0.bmp");
        put(306, "Font1.bmp");
        put(307, "GlockenspielBar.bmp");
        put(308, "GuitarShadow.bmp");
        put(309, "GuitarSkin.bmp");
        put(310, "hands.bmp");
        put(311, "Harmonica.bmp");
        put(312, "HarpShadow.bmp");
        put(313, "HarpsichordSkin.bmp");
        put(314, "HarpSkin.bmp");
        put(315, "HarpStringBlue.bmp");
        put(316, "HarpStringBluePlaying.bmp");
        put(317, "HarpStringRed.bmp");
        put(318, "HarpStringRedPlaying.bmp");
        put(319, "HarpStringWhite.bmp");
        put(320, "HarpStringWhitePlaying.bmp");
        put(321, "HornSkin.bmp");
        put(322, "HornSkinGrey.bmp");
        put(323, "JingleBells.bmp");
        put(324, "KeyboardShadow.bmp");
        put(325, "Laser.bmp");
        put(326, "LeatherStrap.bmp");
        put(327, "maraca.bmp");
        put(328, "MarimbaBar.bmp");
        put(329, "MetalTexture.bmp");
        put(330, "Ocarina.bmp");
        put(331, "PianoSkin.bmp");
        put(332, "PianoSkin_Wood.bmp");
        put(333, "Pop.bmp");
        put(334, "PopBottle.bmp");
        put(335, "PopLabel.bmp");
        put(336, "Recorder.bmp");
        put(337, "RubberFoot.bmp");
        put(338, "ScreenGradient.bmp");
        put(339, "ShinySilver.bmp");
        put(340, "SimpleWood.bmp");
        put(341, "SongFillbar.bmp");
        put(342, "SongFillbarBox.bmp");
        put(343, "SphereMapExplained.bmp");
        put(344, "Stage.bmp");
        put(345, "StageString.bmp");
        put(346, "StageStringPlaying.bmp");
        put(347, "SteamPuff.bmp");
        put(348, "SteamPuff_Harmonica.bmp");
        put(349, "SteamPuff_Pop.bmp");
        put(350, "SteamPuff_Whistle.bmp");
        put(351, "StickSkin.bmp");
        put(352, "SynthDrum.bmp");
        put(353, "SynthSkin.bmp");
        put(354, "TaikoHead.bmp");
        put(355, "TamborineWood.bmp");
        put(356, "Telephonebase.bmp");
        put(357, "Telephonehandle.bmp");
        put(358, "TelePhoneKey.bmp");
        put(359, "TelePhoneKey0.bmp");
        put(360, "TelePhoneKey0Dark.bmp");
        put(361, "TelePhoneKey1.bmp");
        put(362, "TelePhoneKey1Dark.bmp");
        put(363, "TelePhoneKey2.bmp");
        put(364, "TelePhoneKey2Dark.bmp");
        put(365, "TelePhoneKey3.bmp");
        put(366, "TelePhoneKey3Dark.bmp");
        put(367, "TelePhoneKey4.bmp");
        put(368, "TelePhoneKey4Dark.bmp");
        put(369, "TelePhoneKey5.bmp");
        put(370, "TelePhoneKey5Dark.bmp");
        put(371, "TelePhoneKey6.bmp");
        put(372, "TelePhoneKey6Dark.bmp");
        put(373, "TelePhoneKey7.bmp");
        put(374, "TelePhoneKey7Dark.bmp");
        put(375, "TelePhoneKey8.bmp");
        put(376, "TelePhoneKey8Dark.bmp");
        put(377, "TelePhoneKey9.bmp");
        put(378, "TelePhoneKey9Dark.bmp");
        put(379, "TelePhoneKeyPound.bmp");
        put(380, "TelePhoneKeyPoundDark.bmp");
        put(381, "TelePhoneKeyStar.bmp");
        put(382, "TelePhoneKeyStarDark.bmp");
        put(383, "TimpaniSkin.bmp");
        put(384, "VibesBar.bmp");
        put(385, "ViolaSkin.bmp");
        put(386, "ViolinSkin.bmp");
        put(387, "Wood.bmp");
        put(388, "WoodBleach.bmp");
        put(389, "XylophoneBar.bmp");
        put(390, "XylophoneShadow.bmp");
        put(391, "Zapper.bmp");
    }};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the exact path of the HWF file:");
        String HWFPath = in.nextLine();

        byte[] HWFBytes = filePathToBytes(HWFPath);
        // C:\Users\wysko\Downloads\raw-midijam\midijam.hwf
        ArrayList<Integer> listOfLengths = new ArrayList<>();
        for (int i = HWFBytes.length - 8; i > HWFBytes.length - 8 - (FILE_COUNT * 264); i -= 264) {
            byte[] sizeBytes = new byte[4];
            System.arraycopy(HWFBytes, i, sizeBytes, 0, 4);
            listOfLengths.add(byteArrayToInt(sizeBytes));
        }
        Collections.reverse(listOfLengths);
        byte[][] texturesAndModels = new byte[FILE_COUNT][];
        int srcPos = 0;
        for (int i = 0; i < texturesAndModels.length; i++) {
            texturesAndModels[i] = Arrays.copyOfRange(HWFBytes, srcPos, srcPos + listOfLengths.get(i));
            srcPos += listOfLengths.get(i);
        }

        int option;
        while (true) {
            System.out.println("What would you like to do?\n1) Export model/texture\n2) Export all textures and models to folder\n3) Replace model/texture\n4) Load all textures and models from folder\n5) Save HWF file and exit\n6) Exit without saving");
            option = Integer.parseInt(in.nextLine());
            switch (option) {
                case 1:
                    System.out.println("Enter the ID number of the model/texture you want to export:");
                    int id = Integer.parseInt(in.nextLine());
                    System.out.println("Enter a filename for this export (overwrites if file already exists):");
                    String outFilename = in.nextLine();
                    writeByteArrayToFile(texturesAndModels[id], outFilename);
                    break;
                case 3:
                    System.out.println("Enter the ID number of the model/texture you want to replace (must be in Bitmap and Milkshape 3D formats!):");
                    int id1 = Integer.parseInt(in.nextLine());
                    System.out.println("Enter the exact path of the replacing file:");
                    String inFilename = in.nextLine();
                    byte[] inBytes = filePathToBytes(inFilename);
                    texturesAndModels[id1] = inBytes;
                    break;
                case 5:
                    writeByteArrayToFile(buildHWFFile(texturesAndModels), HWFPath);
                    System.exit(0);
                    break;
                case 6:
                    System.exit(0);
                    break;
                case 2:
                    System.out.println("Enter the path to a folder (will be created if does not exist) where the models/textures will be exported (overwrites any existing resource files):");
                    File outDirectory = new File(in.nextLine());
                    if (!outDirectory.exists()) outDirectory.mkdirs();
                    String outPath = outDirectory.getAbsolutePath();

                    for (int i = 0; i < FILE_COUNT; i++) {
                        writeByteArrayToFile(texturesAndModels[i], outPath + "\\" + filenameID.get(i));
                    }
                    break;
                case 4:
                    System.out.println("Enter the path to the folder where the models/textures will are located (all files must be in Bitmap and Milkshape 3D formats!). If not all files are found, missing files will be ignored:");
                    File inDirectory = new File(in.nextLine());
                    if (!inDirectory.exists()) {
                        System.out.println("Directory does not exist");
                        break;
                    }
                    String inPath = inDirectory.getAbsolutePath();

                    for (int i = 0; i < FILE_COUNT; i++) {
                        File resourceFile = new File(inPath + "\\" + filenameID.get(i));
                        if (resourceFile.exists()) {
                            texturesAndModels[i] = filePathToBytes(resourceFile.getAbsolutePath());
                        }
                    }
                    break;
            }
        }


    }

    static void writeByteArrayToFile(byte[] arr, String filename) {
        File file = new File(filename);

        FileOutputStream fos = null;

        try {

            fos = new FileOutputStream(file);

            // Writes bytes from the specified byte array to this file output stream
            fos.write(arr);


        } catch (IOException ioe) {
            System.out.println("Exception while writing file " + ioe);
        } finally {
            // close the streams using close method
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error while closing stream: " + ioe);
            }

        }
    }


    static int byteArrayToInt(byte[] bytes) {
        return ByteBuffer.wrap(bytes).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt();
    }

    static byte[] filePathToBytes(String path) {
        File file = new File(path);
        byte[] allBytes = new byte[0];
        try {
            allBytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allBytes;
    }

    static byte[] buildHWFFile(byte[][] modelsAndTextures) {
        ArrayList<Byte> buildingBytes = new ArrayList<>();

        for (byte[] modelOrTexture : modelsAndTextures)
            for (byte aByte : modelOrTexture) buildingBytes.add(aByte);

        for (int i = 0; i < FILE_COUNT; i++) {
            String filename = filenameID.get(i);
            for (int j = 0; j < filename.length(); j++) {
                buildingBytes.add((byte) filename.charAt(j));
            }
            buildingBytes.add((byte) 0x0);
            for (int j = 0; j < 260 - (filename.length() + 1); j++) {
                buildingBytes.add((byte) 0x0);
            }
            byte[] fileLengthAsArray = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(modelsAndTextures[i].length).array();
            for (int j = 0; j < 4; j++) {
                buildingBytes.add(fileLengthAsArray[j]);
            }
        }
        buildingBytes.add((byte) 0x88);
        buildingBytes.add((byte) 0x01);
        buildingBytes.add((byte) 0x00);
        buildingBytes.add((byte) 0x00);

        byte[] finalArray = new byte[buildingBytes.size()];
        for (int i = 0; i < buildingBytes.size(); i++) {
            finalArray[i] = buildingBytes.get(i);
        }
        return finalArray;
    }
}
