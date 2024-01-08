package com.jonas.file;

import org.junit.Test;

/**
 * ImageTest
 *
 * @author shenjy
 * @time 2024/1/8 14:30
 */
public class ImageTest {

    @Test
    public void testBase64ToImage() {
        String base64Image = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAIAAwADASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDoKWkpazAKKKKAFooooAKWkpaACloooAKWkpaACiiloASilooAKSlooASilooASloooAKKKKAEopcUUAJRS0UAFJS0UAJSUtFACUlLRQAlGKWigBKKWigQmKQ4pSecD8aTAHP86AEyKM47GhnCjk4qF5wPu85oAlMmOg5phy/JJb9BUYkUerNSGU9yFHtzSGPI/D6CjJHRs/UVA88Y7k/U1E99CowZVX8jQBcEuPvDHv2qTJ7YNZq3qOMLIrfQ1LDcbGAJBQ/p/wDWoAugilpm4cZ6fypwPY0wFooooAKKKWgBMUhp1IaAGGinEUmKACiloxQAlFLSGgBpFJS5ooASkp2KTFACUUGigBuKQinUhoAYaaac1R0AIaSloxQAh6VXm6VZIqtN0oA5bWxwa5k966jWhwa5g9TUm0diu/Wlb/V0kn3qd/yzoKMyUfPV+16CqMv+sq9bdBVIyka8H3asp1qrB0q0nWgzNC37VoJ0rPt60I+lAEy06mrT6BCUUtFIYlFLSUAMNJTjSYpiCkpcUUgOspaSlplBS0UtACYoxRS0AFLSUtABRRS0AFFLRQAUUUUAFLSUtACUUtFABSUtFACUtFFABRRRQAUUUUAJRS0UAFBFFFACUYpabn0/OgAxRTWOBkt+VMJY9yPrQBLkDvSEgdSKqyXIjAGCXP8ACKoyzM+WkkVVHfdx+FAjUaZF75+lRPeBRwpJ9uf5Vy934ht7JiJEJ29N3H6Y/wA/zxZ/HmJP3MZYdxjA9vf/AB9qBpHf/a9qjKkH0/x9Kq3Gpxwgl5FXHOM84/pXnN141upVYLiMHoFJzWBdazd3DH96wBPPNA+U9R/t6CViEmjU/wB4nJq5DfRTLuaUEdAc9T7V4mZZA2d5B9c1Yi1W5iOVuJCwGPWiw7Hsk1+iLgYQe/8AhWFqHiWC2BG/zDXALrV1ICssjsPQmq805k5LUrAom7e+K7uZiEcxr6J1rLfWLljnzZD/ALxzWY746VCZT6gU7FGymrzqepU/3kJU/pWvp/iu7hwrSiVe4f8AxrjfM/2hT1lIOc5p2Eex6X4giuYgh8xX6bcZAroLe7WYAEjPqOleI6Xq0tnMrxtgjt7en0r0zTNUh1CBZoSBJj519fWkS0dYOlLVO0ud4CsevTP8quUCClpKWgApDS0hoASkp1JigAooxRQAUhFLQelAEZFKBQetGaADFFGaKAGmkp2KQigBKQilxRQBEwpuKkamGgBhFApTSUABFVphxVo1Xm6UgOX1kfKa5dvvGuq1n7prlm+8aRtHYrSdad/yzpJOtOA/d0FGZN/rDV226Cqc33zVy26CqRlI1oOgq0nWqsHSrSdaCDQtu1aEfSs+27Vox9KBEy0+mrTqQCUUtIBQAUlOpKAGmmk0402mIAaKKKQHW0UUtMoKKQ0ZoAdRSZooAWlpKKAFpaSlxQAtGaSkoAdmikFOoAKKKWgApKWigAooooASilpKAFpKWkoAWiijFACUUuKCQoyaACkJwOaY0h7D9KhkmCjlhx1JPAoAmZs+wqEzjOF5x37Vk3+swWykkliO5OB+tcnqPi9mOIDyOOOB+f8A9YUBY7uS8ijGS4yOcmsm98R2tupAdd3P3mArzq51u+mZikmzPXaeax55XkfLFiW4zmnYdj0C98Y2yIdkhZsdE/xPFZN74rM8JWGIqc8O55rlkj3HJ+6O1SFXkOAMD8qLDsJdXclw5LuW/pVXBHsKsmIIPUj16CoJCG6tn2HSmMgYge9Myx6cD8qnwOuFH401mA/u/wA6BEO0noCfpThHIfRaUyN700s3c0AL5f8AekP4U5Qo9Sfc1FuHrQH9MUDJjGjcmo3th1WgNj+L8uKcJQO2aYiq0RBxtpmCDwcVoZVx8y/nUbwAjK0AVkfaeeK3dE1iWxuVw5AJ/WsQx7TjOKUZXuD/AEpMZ7XpF/HeRBkI55wD0Pcf1/GujibfGD3715D4QvNRM7vBBJPFFjzQnJHpx3716Xp2rWtzHlJAc8gD1qE1exLRrUVB5zn7sZx7mlEzD76ED1HNMRNSUBgRkGigAooooAKKKKACkNLRQAzFGKWigBMUGlpKAEpDS0lACUhp2KaaAGNTDT2phFADTRSmigBCKrzdKsnpVeYcUgOZ1j7prlm+8a6vWR8prlW++aRtDYrSdacPuGmy9acv3KCjMn/1hq5a9BVSf/WGrdr0FUjOZrQdBVpOtVYOgq0nWgzNC2rRTpWdbVpR9KBEy0+mrT6QDaKDRQAGjFFFADSKbinmmE0AGKKKKAOspaSlFMYmKMUtFABiilpKAFoopaAAUZpM0UAOHNLiminUAAFLSU6gBKWiigAopaSgAopaKAEopaSgApKWjFABS0mKdQAnQZNROxz/AJ4pZpFRSScAdayby8Cp8x2jsucZ+voKAJp7xUUhPxb1rk9Y8SrGxigPmSDgkHhao6xrrzu1vbMdnQuO/sPasAg9eRRYpILq6mu2JkYsfQnAFVGjAHIp80qp/H+RqhNcE8rz9aYx8smw9M+lRCVZCeearMzOff1q1Z2sksikAsT0pgWY8HjoB3qfGR93A9MUskJgG1gMjrUI8yTovHuKEAyQKepB9qrORnCoTV/yAPvnOfU01lRRwefamIzWjkP3vlHuaiKAfxA1fcg8BG/lVZ9x6DA96AKx4phx71MQO7D8KaSB0egCLHooNGGPGD+Ap5dv71N3E9/yNAAFPcGnD8vrTOaT5vSkBMMetPD471WBPoT+FOGfT8KALBCyDBHNVpI2jOR0qRWb0wKmBBHP60DLvhzX20S6kkG7bIoB29QR0NRnVrltSnu7eV4DLIXwpx1NUmgBGVxUPzIcHioUIqTkt2O/Q6qDxnrcQC/aztHcoDWpD4q1ScDZqkBY/wALR4/pXDrKR1p24GmKyPQLTXNeaYxRSwSOfm5wAfpWqviHXLRQ15pu+Pu0XP8AKvLkuZ4yNkrAjpzWzZeLdTscK5Eqejf40Csep6V4hstUXEcgWTujda168Zn8QW9zdR3cUZt5wfnC9G9/rXpujavFc2sYklXeRwc9aBNGzRSAgjIOaKBC0UlFABSUZpN1ADsU007OaaaAEooooAKQilooAjYUwipWFRkUAMNJTsUYoAbUEo4qwRUMo4oA5rWR8hrlH+8a6zWfuGuUf75qGbQ2KkvWnr/qzTZetPT7hplGZcf6yrVr0FVbn/WVategqkZzNaDpVpOtVIOlW060GZoW1aUY4rNtu1acfSgROtOpq06kA3FKBS0tADTSU6m4oAQimkU+kNAhuKKWigZ1XeijvRTGLS4opaAEopaKAEpaKKAExTgKSlFACgUtJmlzQAUopKWgApaSloAKKSigBaKKKACkzRRQAUUUooAWms4UUE9vzqtcSqkZZjhQOvoKAKd5chF3tzj7qk9T61weuay9xK8EL8Z/eOP5Vd8R60wYwxHEjccfwiuXUBRk/if8/wCf50JFJAMgcDA9upqtcS7Rlm4+tSzStj5fl96y53GSTz70xjJZcn5QMVAXPemvLzxTUyzZFMC1awtPMqgdTiupht00+z8wL++b7vsO5qjoljvmDycIOSQela+o3kX+riBCgYGSRx+NSxoxJpjuJKgVEJpGOBjH1NK4ViTkfpSFcDgn8hTQmL5W8fNioXjZPXHpin7lA5/lj+tBY4+XH51QiqzDHOR9DUTMp/i5/KrEu0/eXB9xVOSNT0I+lADHC/3j/OoSB/eFKykdvyqI0AKR6EUnPrSUlADsnvSgnsaZRxQBKHJ9/wAaXePcVFnPX86Xn6ikBLkH+KlGfY1ECD7GlBx0P50AThiO2PoacRvXDDIqEN6j8qcD3U0hjWTB4JqPeVPP51YD9mGaa6AjKn8DTAYsgNWIZmTjIKnqOxqmRg4xg05WwcGkBoTQQSoHjGwnrjkf41L9k1axhWeLzGgPIeI7lH5dPxqtbzbH5GVPUGu28Mho5isL5jkGQh6H1+hoBmVpPjm/tHWOaTcnuK9P0bV4tWtRIuAwHIBrz3xfo9lgzwrsuO4RMZ+vrVP4eapPb64LPlopFPH93ikJnsFFIGzS0EiEU3aafRQAgFBp1IaAG0UGjNACYopaSgBDUZqQ00igBlIacaaaAG5qGU8VMagl6UAc7rH3DXKP9811er/cNco/3zUs2hsVJutPT7hps3WnJ9w0FdTNuf8AWGrNp0FVrn/WGrFp0qkZzNaDpVtOtVIOlW060GZoW3atOPpWZbdRWpH0oETrTqatPpANpaKKACm06mmgBppKdSYpiG0UtJSA6ulpKWmUFOFIKUUABpKU0UAJS0UUAFKKSnAUAFGKKM0AKKWkFLQAtFFJQAtFFFABiijNJQAtFFHUUAGKCcCjA9/zpp645wPWgBjNx7fzrnPEuqLZ2+0tyPmPuew/r+Vb80qxxvI/CqM15Zrt+2pam6g/IjEn0J/wHT8KQ0Z+555GmkyWY557Ur4QZf8AL0/z/n2cWAXPU9h6+9UbiQtwOT3qiiC6ucnav4CsyRiTlj+Aq1KMEgct3xVRxg8mmBEBk/dwK0LK1E0gHODVSJQzjjNdLpFsWZfkBOehpNgkbdraxW+nGMJGWbuTzj2zWRdrsJVOg7EVp6lGVJZE2rnknrWLPI7kgtkqO/pUotlVtoPK4+hoWcLweR78UMwPDAj3pphDDI+Ye3WqIJfkccHB+tQvGw+7jn260CA/wOR7GnAuow65piKztIOCD+FVZGB6jHvWmVVuVODUEkanh1/EcUwM0kdiD9ajYEHuKtTWuBmM5HpVUhk47elADMkdcUcGl4PTg+lIR+FAARRScilzQAUoOKKKAF4PsaMkcEUmacPQ0AA9QaeGB68Gm49OaUYIoAlPIwefrTclT7UgJXrytPwCOv0pDI3UEe1Rj09Kl7EVHwfrQA5WrrPC95uYx5+dPmWuQB5q/p121pdJKp5FIZ0Gt6u8/nJIuCAct39MVb+HOms97PqDLwo2L+PWuXvpvtdydo5Y9BXrvhmwXTdHhgwA+3LfWpb0EzbQ1KKjWpBRcgWiiimACg0UGgBKTFLRQA2iikoADSGlppoAaRSYp1JQAwioJRxVg1BL0oA53Vx+7Ncm/wB8112rj92a5F/vmoZtDYqzUsf3TRN1oj+7TK6mddffqe06Cobr75qa06CqRnM1oKtp1qpB0q2lBmaFt2rUi6Vl23UVqRdKBE60+mLUgpAIaSlNFACUhp1IaBDaaadTTQAlFLikoA6qlopRTKAUoooxQAGkpTRQAUUUUALS0gpaACiiigBQKWkpaAFpKWigBKWkpaACiiigAooozgZoARjge9MY7VJ9P1pT+p/So532KM8d6QHOeKtSNpYeUrDe/WvPVXAOepOWPvWz4hvjd6i4zlVOBWOP73X0HrTRaVkNlJAx0P8AKqcnQ44X1q24xnJye59TWdcy54X9KYFWZscKAKq4DHPU1M6Fj83PtU0FsZGAxRcdgtIWdgAK6/SbZY1LsxVgPlPqapaZpnRnGE71szQObVQihlH3lIqHI0USG7ufPj/55uucjP8An/PesSdM5OPyFW7qHIz8xPY9x/jVPdKvX5lpolopyAqcE/QjpSKWQ5xn+tXMJJkFcH0IqJ7fZyny/qKpEtCqVl9mP6/40jfL94ke4PFR5AyrDP0pS/y9dw/M0yRpCnORj3FQSggdcj1FEjYGVOR7dqrtN1z+dMBjttPHFRMwb7w59aJG79RUJ9R0oAR0GM9vWmdODyKcGI6flQcHp+VADCPTpScGndOlGAelACYxSg0mCKKAHUdKbmnUAOBpSAeo5pv0pQePUUAOGR7inDA5HTuKaPY5p4wfY0hiEZ6VXzhqsfd4PTtVeQbX56HpQAZ5qRGIqIVIlAG54ctftWrRbhlUO7/CvYrSMgbW/CvJ/CziO9UE4LdK9ftiJIEfuQDUCZOq4p+KRTke9OoJEopaKAEopaDTAbRS000AIaKKKAA00inUhoAYRSU4ikIoAYaikHFTGopOlAHPauP3ZrkJPvmuw1f/AFbVyEn+sNQzaGxUmoi+7SzURfdoK6mddffNTWnSorr75qS07VaM5mtBVxKpwVcSmZl+26itWLpWVbdq1YulIROKkFMFPpAIaKWigBKQ06kNADaaadSGgQlNNOpDQM6qlpKWmMUUtIKWgApKU0UAJRRRQAoNKKbTqAClpKWgApaSloAXNFJRQAtFFFABRS0UAJQev0pab/U0ANY849qyNZuhBYzyZ5A2j61qyMFcn0Fcj4rufLtVjHVuTSGtzibh98rEnOTijOFz1J6VAW3SHnheBS53DOeP6U0WyKdy3Tp296oy4U+rVJdXO1tife/lU2n6dJcyA7ScnrQ2NK5DbWjzMPl4rpdP0VsD5Pm+nStvStBWJASoLdM+ldNaacEARV56k1k5XN4wtuYdvpqpGoUEgEZNaKaf5kbAqQc4FdHBpqBRuXJ/lUn9nBGIUkcdulLUo4m60dOQyd/vdv8A61ZF34fdSWQA16U9g/cK4+mKoy6XgHapU+nUflT2FZM8smsGjYptYEfw/wD1qqsSmQf1r0u60pZE2yxhv8+9c/feGkOSuR+Gf51SkQ4HGTKjjPQ1nyFom4revtHubXJKbl9RWNMhHDD8apSM3GxUeTPPQ+vrVd2554qaSMr05FV2B59PSquRYYTzx+NMPByKVh6UnUH86Yg69OvpTaM/nS9frQAmfXr60dKKP5UwFznrRikpc+tACFaTBHSn9PcUYzQA0HPsacDz70Y9aMev50AOx6cGnBucGmA469KkxketAxx54/nUbLkFT+HtS8g4P4Glb9aQysBg4NTRDLCmuOc1JF1BoEjXs3MLRzJnKNzXruhXIuLMYPTBH0NePWbZYxn+IV6J4MvN0CxseRlT/SoCWx2Y6/SndaQdc0vQ0EC0UUUwEpDSmkNACZpM0GkoAKKKKACkp1NNACGmE0+kIoAZmopOlTkVFIOKAOe1f/VmuPk/1hrsdXH7s1x0v+sNQzWmVZqIvu0s1EX3aC+pn3f36faU27+/TrSrRnM1oatpVSCraUzM0LbrWrD0rJtuorWh6UhFhafTVp4pAJRRRQAhopTSUCEptOpKBiUhpaDQB1ApcUgp1MYopwFNFLmkAEUlLTTQAGikooAWlzSUUAOFKaQUtABS0lLTAKKKKAFooooAKWkpaACm+n1p1Nbge/b60AQXHQj+9kV5z4tvWe7Zc/dyBXf6hMI7eWTsBx/n64rybVZzPfvk5waRcSoDhQPWob248mMKpG4/pUu4KGkboKyS7XVwTjPOMUyi3plk13ODg4Jr0rQtFCIpKcnpx0FZXhfRslAV56mvR7a2WCPIHsKyk7nRCNkRW9mFPAzt4H1rWtrQKBxRbwDIHXHU+9aUUYxQkDZGkGO1K8WMGrojAHSkZQRz3q7GfMUCnHSoWi5NXCuDg0xlpWLTM6SEcjAqjNZo2cDFbDrVaVPapaKTObutNDDlQR6iuY1Lw5DMWZVAY9wMV38q8Vn3Fur5JHNSO1zyO/8AD9xbsTGu5fSsKaEoxDKVI6givZLmxDDHaub1PQ4pwdyA+h6VSmZyp9jzZ055qIgo2eorob7Q5rckoCy/rWO8RHBH4VqpXMpRaKbrg8dO1IPSp2Tjb+IqEg/iKogPrRSdRSA4oAWl/lR15FFMQD2petH6UUAOzjqKXGelN5FLgHpSAMEU5Tg0gJHGafuB6gUDHEBlqLnO09exqUbfUio5AVI7jPBoAaeV+lLGcUgOc0g4NIZcjcoyuO3Wus8NXnkagAD8rkMK5GAgvtPQ1o2E7Wt0qHhlOVPrUsD3GNg6Bh0IqSsrQrsXVgjA5wK1aDMBRRRTASgilxQaAGUmKdikoATFGKWigBDSUppKAEpDTjTaAGmoZDxUxqCTpQBg6v8A6s1x8v8ArDXYasP3bVx8v+sNQzWmVZqIulLNSQ9KDTqULv75pbSi8++aLTrVIzma0FXE61Tgq4lUZF+27VrQ9KybbqK1oegpCLK08UxafQIKKKKBiUlOpKBDTSU40lADaKWkNIDqBS02nUFCilpBS5oAKQ0uaSgBKKQ0maAHCnimCnigBaKKKYBRRRQAtFJS0ALRRRQAtFJRQAtHbcaTqcU2Q54/E0gOf8Q3Ih0wE8bhu/T/ABIry6RixZ+u44ruvGdyEtBEOrNtGPQH/wDVXCE849P50GkdipqM3l24QHljk0/w9aGe7UkcKM/iaz9QcvKB6f5/pXYeCLIzSKccM2c+wH/66JaIuCvI9J0GwEFspI+Yit+NNzBiOF4H1qG1hwoUcDGD7e1aCJjAA44rJG7ZJCmOKvRDnGKgiHU1ZjHNWjORLjIprDPNPAoI4qzMqyLz04NQsMfSrTrxULCpZaZVYVXkFWmFQOPWpZaKMi1UlStB1zVWRaku5lyR84qhcwZBOPrWxKmaqSr6ipGc9cWquMECud1LRI5csq7W9RXZTw4OPyrPmj9RTTJaPM7vTpbdiGXjsazpYyDnHPevR7yySQEFQQa5fUdKKE7F+nvWkZmModjmiMHI6GkYd6syQlCQRwai24GK1uZWIfpwacG7Higr6flSUxD/ANRRimgEHjinZ9R+IoABkUufbNJ9DmlH5UAOBBFBXPekAOKC2OopDAh19xS78j1B60vlTlN6oSPao3DAfMpB9xigAHBPtTVOTSFsikT71AFqFgJBnpWzqVsPKhuYc4I61hA7SD6V1mmhb7R5IT95ORUMZ0XgXVQ+YHbnpj3r0AV4npk8mlapFJyEZq9isbtbm3R+5GfrQiZFqilpKZItJRRQAlJS0hoAaaKKUCgBDSZpScVGzc0AOzSU0GlzQAGoJOlTGoZOlAGFq3+rNcbL/rTXZ6r/AKo1xs3+tNQzWmVpqbD0p03Smw9KDQpXn3zSWnWlvPvmktOtUjOZrQVbSqkFW0qjIv23UVrw9KyLbqK1oegpCLS1JUa1IKBCGig0UAFBopDQA00UGigBKQ06mmgDp6KSlFIocKU0gooAWikpc0DEIpMU6gCgQAU6kpwoAKSlpKYBS0lLQAUtJRQAtFFFAC0UlKKAAHAJqKVvLiLd/wCtSDnaPxrE8R6h9ksiqn524A/z/nrSA4XxPe/adRIBykXA9/eucdsRk+2avamSrlT97ofr1rNuGwmOxoRqZlyczfjivXPANht09ZcYJHy15DIc3H0Ne+eEIBFo1qMfwA/pUz6GlLqdTCgCDA47VaRetRIuMEdKsoOKSRbY+MfKKsqtQKMHFWFqkQx/QUh4HSl/lSdaogYRzUTKOfSpyc9ahkI6CkUiq45NQOKnY5JqFqk0RVdQagdT9atPUDVIynIlVJU4xir8jADmqU00Q43qD6ZpWKuZ0yZBHftWdMueen9K1JZUP8QzVC4IB3djwaVhXM2VAVPH4VnXNuGUqRWs+N31qvJHkY/I0COMv7DY5yPlb9Kxri0aNuld3dWyuCGXr1FYF1a7D5bDI/hNXGRnKJzDL+FRMtaVzb7D0qmw/GtUzJog5HSnA0p/X0NJjHaqJFAFBX0NIOacKQxuSOooXLsF9TUkcTzNsRcmpzpt6h+SPcO+2k3Yai2adnH8oz0Fb9tbwTW+yWNWU9mFczbzvAQkiMh/2hita2vwGVc+1YyudcUmiLUPCStmSxcKevlt0/A1zVxZ3FlNsuImjb3HX6V6baSJIo5zVmWxt7uIxzxLIh7MM01UfUzlSXQ8oPSt/wAMXPl3YjJ++Mfj2q9rHhAwo0+nksByYm5P4H+lc3ZSmC5VhwQau6ktDFpxep095YiZbmFQfMQ+ZH/hXX+CtSF5pghkPzx8VgGQNc2t2v3ZBtP+f89KdpJOk+JpIQdsU/zp+PP+IpJktHpQJHuKdkEcVFDJvQHv3qTFUQLRSZI60uaAEpDS0UANxTqSloAawqIjmpTUZ60ANAoNOpppgFRSdKlqOTpSAwtVH7tq4yf/AFprtNV/1Zrip/8AWn61LNaZXl6U2GnS9KbFSNClefeptp1p1594020+9VIzma8FW0qpBVpaoyNC26iteHpWRbdRWvD0FIRZWpO1RrUgoEJSUpooASilpKAENJSmkoAKaadTTQB01FFFIsdRSUtABS0lKKAClpKUUCFpaSlFAC0lLSUAFLSUtABRRRTAWikpaAClpKU9KQDGYRxFz0ArhtQmOoauzMf3UGWPpmuk8QXws7A8846fy/X+VcfKfsmlMxOJZjk56/5wP1oZSRzN/KZr1j3ySR6VmXDbm46datSMWZj3Y8VRnb7xHToKEWUHPzFvevovwwn/ABJrU+sa/wAq+dZBhVr6K8IuJPDtg/rAn8hSn0Lp9TpogMYxxUy/L7ioY2GOoqQNSLZMCOCCKkB9OKrbh3o3UybFrzD/APqpplA9fyquXphb3ouNRLDTelQvJiombjrVeWbbnmlcaRK71XluUjUlmAFY2o6v5CHZ96uR1DUb28LZdsE42g4pXKsdZfeJrG1JHmbm9F5rnLzxsx3CCIAf3j2rGg0W6mOcHce5rUt/Bcs+DcSYHvzQLUwb3xTfzk/vWA/2O35VmNfXcxOJX59VINeiweDNPhA3qZD71a/sWxhGEgQfhRcOVnmUd1qkZG2WTHv/APXq9BquojiRQ69+K7eTT7df+Wa/lVWSyhA4RfypNjUTChvHkXlTx6c4q1uDKGHSrEtoinKqM1AF2Nj+E9KkZDLHkdPwrKvbYOhUjPoa2mH5VWnjDKRihMT1OMuo+oYfMOvvWTNHg102p25Q7sexrBmHJyOlaxZjJGcw7Gmcg8Eip3UVGRWhmN3fSnRRvPKEXvUflntVuymNs33A2aT2HFJvU2rOyWFQoHbJPrWzpsQmlIA4GAa506g6If3Z56c10HhC4Vid3LMSST61g092dia2Rs3GixSR4aNWGOhFcnq+kvYhpoAfLX7y9So9R7V6Uqh19SaztQsw6H5eaSdhtHA6bqxjxubgV3WlymeNWbv2rzfV7H+ztUVUGInO5R2HPI/z6iu+8Pybol+lOSXQUZNrU2LiL5OK808TWIs9V85Fwk/zf8C7/wBDXqsiZjrivGFpv00ygcxOG/Dp/WiDszOoropaTJ9q0lo/4oTuH0rQ1XIjsb9fvRsFJ+vP9DWD4XuAl8Iz91xg10F8AumTW7H7rBl/Aj/GtDnO80+cTWsUq9GUVernPCsxl0tUJ+5xXRKciqM2OopKKAFpKKKAEoooFACGmkU80lMBmKQinGmmgBpqOTpUpFRP0pAYeq/6tq4u4/1p+tdrqv8Aq2rirj/Wn61LNYFaXpTYqfL0pkVI0Kd5940y1+9T7z7xqO1+9VIzma8FW1qpBVtetUZF+16itiDpWPbdRWvB0pCLa08VGtSCgQhooNFABRRRQA00lKaSgApDSmkNAHSUtJSipLFopDSigBaM0lFMBaUGkooAdSikpRQAtFFJQIWikpaAClpKWgApaTNFAC0jdMepAoqvf3AtbKWZuiKTQM5XWpTf6ysHWKE7n9z2H+fesHxBP8mM9FA+mef5Z/OtS1DmFpHP7y4JdifQ8D+prmtfuQ9xgdyWx7dv0x+tItIx5G2qx9OBVGX7oHrViZui1XHzTY9KaKZDOuAK9E0nxXdQ+HbKygPlhECvJ3/CvPbn7gr0v4f6VaavpGZeTC20r69x/OhjjvoRr4k1KL5orlznnBb/ABq7D461VWCuwb6rXXR+E9KiOfJB/wB7mn/8I5poGFtowO4xxU3NLGLZeNrxiBPCpB7jjNdPY69DdquflJ7VmPoVpHny4wufSmrpywnKcfTilcpI6lZQ4yDSk+9ZNnK6YVjkVqL8w4ovcNhrtxzWbdOwHFaMqkCsu6bbnNJjRj3FuJWJb16U+202NmyUBqQOGkxWraoAvSkDC3s0QD5RVhgqLyQKoalqn2Mx28Cq9zLyoJ4Ve7N7fzrkdX8T6fFGiJ5mpXpfBGG8sYxngHHXjAyfX3a10QPRXZ1dxqVpCSGuIgf98VRk1O2kz5cyN9GBrzvWvEk4uZ7WSxisrmJ2DwSRFXX2Oe+D3x/KsiC+ubxnENojmIZYJwR70+Ri9pBHqMlznoRVdpvzrz228QSwybPNlUDjE2CP8a6K21Q3CAnGT/dORUNNbmicZbGy75FV5Fzx60yOQtVgIWWkJor9Qc9R1qJxViRCuGFRsAwoJMfUYN8ZGOorkbpCGPrXd3Me5CDXI6lDhycdf51cGZzRiOKjCBjgmpnU56fUU9YwcEdK2uZWGrb8jOMHvVqO1VeccVAQVIwGH0pwmmXgKWH0xUO5pFIkkTCEU/Sb59OvVOMoT0qBp5SDmMAd/moxkZK8expepfW6PZLNR5CluWIBNLdRhlPFVfD7mbRrSUg5aNSc/StSRMr0rM1POfGGn+ZZeci/NC2/8Oh/ofwqx4Zm3Qoc9RXR6japIjIygqwIIPcVzun6dJpc3lZ3RZyje3ofei+hK3OzBDRisTWbX7RZXEOPvoQPritS2k3IM1DeLmkhM8n0mUw30Z9GFdjrRxEjD+JcGuRvoTZa3PHjAWUkfQnI/Suj1KcSadbnPJArZnMdR4SbaJIz9a6xTg/WuS8McXLe6j+VdbjK00ZvcfSUA5ANLTEJRS0hoASikpaAENFBNJmgBDTacaaaYCGo36VIaik6UgMTVP8AVtXF3P8ArjXaap/qzXF3P+uP1qWa0ytL0qOKpJelQxnmkjQrXn3jUdr96n3fWo7X71WjOZsQdKtrVSDpVpaZkX7bqK14OlZFt1Fa8PSkItrUgqJakFAgNFBooAKSlooAaaSlNJQAU006kNAHSUtJRUli0CjFFAC0UUUAFLSUtMBQaUGkFLigBaKAKdigBMUUtFACUUUUCCiiloAKwPFEzGC3skPzTyAH6D/6+K365TWJWl8RKFPFvCT9CR/9cUFIqTsI7WRgAoPyx89RjaP6muD1Cfzr6RhyAcCux8R3KWkaQIc7Ax4/IfzNcJITyRyTx+NIuJC7cFveo4FJBY9+KdN2UdqdGAo+n+FNDZXu/wCtdx8LdT+zaxcWLH5Zow6/7y//AFj+lcNc/dH1q94euJbXxDYywuqPvwC5wORjn86b2CLtI9v1fxHFppVdrPIx2oi9WPpWSPFdxgGWSwt1POJJSxx+HFcp4t1SW7CqbUxtgMG3Aj/gOOorS8BaFDdxTX15Es844XzVDAe+DxmojG5tKVlobyeLIRxJc2D+yTkH9R/WtO01S1vlzFICfTIP6jivIvtlnYRapFfaYLma5QxxS7tpt5A2dwGMdun8qoaRd3ltdRS28rLucL8pocOwlU11PeUfDVsWbbxXJ6LeTXkTRXKhbmLhsdGHZhXTaaSHANQtDSS0NGaH5c1zWqtsBrsJQPs+cdq4rWmPmEe9VMmGpmwPmUVvwuI7dpGOAoya561H73mukktpJtCnFuA1wykR5OBn3/n+FSinqzzfULy51vxBJplsWDzsFmkX+BBxtH4frmneOvD8ujXNhdWBaCOOFUikTgxyIcg57E9fqK6Lw54SudC3XMwt5rqRsu4k557ZIrpr7Zf2Mtpe2UcsLLtZS4Oa0pKysya65pLl2PnSRr/UtZlu76V5biVy8kr8lmPeuq8I2Zl1m5nwNix4Y9iSf/rVtz+CLL7TL9nmvwmPlWRVzn/e/wDrU+HSJrK0+z2z+VETlsfeY+5o59SVRbMHW7CCTUmaEoqj72AOar2ds6SBYycD2rblsFXgD5vXqau2WmYIO3mocrm3Ko7D7CzkZQWrXW12LzU1vB5agVO4GKgVzJniAP1qjIm0n0PatacZBFZ8gzn1oEUJlzGSK57UYA24evIrpZVxkj8RWLfR/KxGeD+lNEtHIyx4fp14pUQFSQOlWrmL52UdeopI0VxyMMOMdK0uZpFUsVIGM8c4qRZFYY6fWkkXMjYxgH0puzueaTNoqwr4KnvxUtpbm7uoLZesjBfpUQUsdoHHf2rovBtp9q1wy4G2BePYngfpmgq2p6LZWy21rHDGuEjUKB7CpHOBzVhIyI+tV5qgGzLuzwazuG/Cr90eTWeOCaRD3LcD7eKmmwyVUjODVjdlcGkBwni+xKXUN6g4b5H+o6f59qgkbfZRHP3Vrr9Ss0vrWWBv4hwfQ9q44gx2jwuMOh2kfjWsXdGE1ZnceFTvbcP7i/yrr17iuP8ABvMAP+yBXYL1NWtjF7gvBIp1MJxIPcU+mISkNLTTQAUtNp1ADTSU40lACUhoJpmaAFNRSdKlqN+lAGJqg/dmuKuf9cfrXb6n/qzXEXRxMalmlMrTD5arJw1W3GVqvswaSNWVbrk1HbfeqS6HNR233qtGcjYg6VaWqkHSra0zIv23WtaHpWRbdRWvB0pCLaVIKjWpBQIQ0UppBQAtFFJQAhpKWk70AFNNOppoA6WlFJRSLHCikopAFLSUUALS0lFADqcKZmlFMB9Lmm5ooAWkoooAM0UlLQAUtJRQAtciMTeIb52AIDouT6bhn9Aa67uPcgVxsknkavqCHPKhuvuQf/QqQ0cv4juDNfygHKr0+n/6zXPHh8+nP41oXsgkmmkJ+9IB17VQYlvkX+Js5Hqe1BotCBlIAJ/i5/CjPyfUE0sxzIR6cCljUu+B2/kKYFa4HyqKjVmiaORThlIYEeoNT3HzEj8qgxlB9aaEetf8I9Dd2CXfLM6BueecVreFtti0qylVic8HOMGrnhpRceGrEn+KBf5UgsjbylNpMe8tgVjdp3OyKUlZnPeK/CD3d695pT28izHdJC0gUhvVc8c+lZ+leDb+C6inuo4QsbbhGJc5PbJGeK71XgH3Yl3ewqdY5p+Fj2r71XPfYXsYrdlfSbKdbyO4lltxtyCscRyQRjG4n6Hp2rpYYwjbgOpqrZ2gjHPJ9avqMPRYmTV7ItTOPs34VxGrtumIrsLx9lv+FcTfNunNEwpohgX5ga6PTpcR+WehrAgXJrVtW2kVKBmjLb5OQSD6iqckNwv3XJrUiYOgz1oaMelWwUrGBJFP/dBqhLaTOTkda6h4ge1QNCM9KlxLUzmU0rnLDJq5HaCMYxWsYgO1QuoFTYL3KZjAFV5eBVqQ9apTNSHYpzGqUnXNWpTyaqt1xSE0V5BWZdJuj/CtR+BVCdf3f4YoRLOVuo8MG7g//WqWCKN4SJCPl6E+n9alvE5YY7/4VFNG8ln5cfDNxk+lXclIx3YtKdoJLNwKtLZSYDStt9h1/Ortrp62w3Z3PjqaW7nCA5FF+xql3M24YRoVQYHb3ruPANn5WnNMw+aZyfwHA/rXBOGkYk9ewr1vw7afZtPghH8CAfpTEbu35ap3HGa0CMJWdc96GjO5kXXWs89av3PU1SI+apFckj4qRmwKjXgUrHNIdxuea4vXSItZmReAwUn64rsq4XVpftGpTyjkCTaPoOP6VcNzOpsdx4IYNaH1HFdgOtcL4KmEbtGejdK7oVojnluDffWn0w8uKfTEJTTTqSgBKWkooAKQ0GkpgIaaRTqaaACo36VJUb9KQGNqQ/dmuIvOJjXcal/qzXEXv+uNSzSBXz8tNwDSnpTQak1KV2Oagt/vVYu6r2/36tGczYg6Cra1Ug6VaWqMi/bdRWtB0rItuta8HSkItrUoqJakFAhTRRRQAUlFFACUhpaaaAEzSGlpDQB0tLTaWkWLRSUtIApaSigBaWkooAdQKSloAWlpKKAHUlJRTAWikooAWlpKKQAT39Oa4/xKn2e9MwJw6sh/EZH6muwrnfEluZrJgo+bacH3XkfoP1oGtzzZwrIzDHMhx9Bn/CqYb5d+e5OPzq0zh4GQghkDH8f8k1TPy26L6nNBqQH7xq3aIBbTSt1wFX6n/wDVVMdavqm2yReQXYk8fQD+tMRnTffcegqGPpj3qVzulJP8WagB2mmhM988DSCTwtp/tEB+XFdObVJDkqM1xPw2uBL4XtxnlGZD+DH/ABrvYyCBWXU6bXSZCtogPAAqxHAB2qRR61IoHpVJCdxVUKOlIvMlObgUxD1NAitqUuI8ZrkLnmYmum1A5BrmLo4YmoluaxVkPhYZrSgPNc+LkK1a9jOsmMUJks37duBVwAEVQtjxVxTxVoVgZBULqAKnY1XkahjSK0re9UpX61ZlPWqMmQOahmqSK0rVSlarUpqnIakbZWkJqu9TvUDUiGQvVOcfuz9KuPVOfoaRLMK5Xc+Pf+lMSMtHx6nFPvWEZZvSoV1KyiQK9xGpHUE81Wo426k7NuTkc1mXCZJZulLPrtkpPlM0hP8AdGP51z2oapNdsU+5H/dXv9auMGxTqxibGlMl7rtvbR/MN+5j2wOf6V7Lpse2MV5L8PLPzNQuLoj/AFahAfc//qr2KyXEYqmknYiMm43ZPL93+lZtxzmtKbpWZcd6UiUZFx1NUz1q7cdTVI9agBwpDSimmkBXvrj7LYzTd1UkfXtXCL95o2+8Rmuu13MlosAP3jk/Qf8A18VyLNuvImH8QFaR2M5vU6/wn80R2/6xWyK722lE0QbvXAeFT5d069ic120TeRcFf4X6fWqRlLcujliafTVGFFLVEi02g0UAFFFFACGm04000wCkoooASo36VIajfpSAyNR/1ZriL3/XGu31H7hrh73/AF5qWaQKxHFNFP7UwVJsVLuq0H36s3VVoPv1aM5mxB0q0tVIOlWlqjEvW3UVrwdBWRbdRWvB0pCZcSpBUSVKKBC0lFFABSUtJQAU00tIaAEpDS0hoA6SiiipLClpKKAHUUlFAC0UUUALS0lFAC0uabS0ALRRSUALRRRQAtGaSimAtZupKXtZCBkqCw/Dr+ma0aglXIPsf50gPHL2Bra8miJAGWP1GM1WuQFt7fC4yGP61r+KY/s+pMOf3bYB9R2/TFY9wwa1tmByQCp49/8A69I1RWQcA4q+T+6TH8HT8v8AP51TjA8tm49P8/lU8TgIoJ6jB/xpjKBHzZPYGoH6irRXaXB6gVVccU0JnqPwovN1ne2hPMcqyAezDH/steqxNkCvBfhzqP2LxXHCxwl0hiP16j+WPxr3aA8Colozopu8S8lSioEqUHimhsdIfl+tN2MIiaZI+MZ6ZpJr4iLA6UXV9SdTLvXxmudvec4rXvrgc+tYUsgd+tZtmpTMJOaS3ums7hQx+UmrgIx0rO1IARMfTmkKx3dhOJYlYGr4JxXJ+G7stAoJ7V1KtkZq0ydh5NQSGpDUMhp3GirLVKU1ckqlKakq5UlqnJVuWqclSFys9QtUz1C3WkIhbvVKc8Grr9KoXRwppCOd1R/4e3U1xcrGa4d+xNdPrU+y3lbPJ+UVzEY4zW9NaXOeq9bDvu8+lQkVI5IGPU0hFamR6Z8PbTZo3m45llLfgOP6GvSrYbYxn0rkvBtr5Xh+wXGCYg358/1rsUQBO1ZdWzrt7qRHMwxWdP3q/LxVCYVMmKxk3A5NUyOav3C81RYYNSQNpDSmkNAzntTvVOoyw9fLi/UjP+FcxGxLRnurVLqt0RrNzKp4ZyPw6UkiBLeNx3rVKyMW7s6zw9iO9Q+rY/MV3JXfFu7jkH3rhPD7jz439MEV3sA3R8nOKCJFiCTfGpqSq9v8rMnvkVOKokWkoooAKSlpKACkNLSGgBppKU0lACGo36VIajfpQBk6j9xq4e+/1xruNQ+4a4i//wBcalmlMq54oFNJwKEOak2Kt3VWH79WryqkP36uJnM14OlW1qpB0q0tUYl626iteDpWRbdRWvB0FITLiVIKiSpRQIWikpaAEoopKYAaaacaaaAEoNFIaQHSUUUVJYtFJRQAtFFFAC0UlFADxRSCjNAC0tJRQAtJRRQAtFFFAC0maKDQAUxhk/UU+mt096APPvGtmA8dxt+U8NXE5/cMufuvkc+o/wDrV6n4ns/temzbRzF8w/z+NeYXMXlOMDCuufx7/wCfekaRehGqkx8e5IqbbvhQjGelLZxiU7exOKnW3KmRQOUNBRRZcjPfGDVNx1rRxlyCOc5xVS5j2ORTQMitp5LS6huYjiSJw6n3ByK+k9Hvo9R022vIjmOaMOPxFfNTDn8K9b+E2tfaNMn0qVsvbNvjB/uN/gc/nRNXVyqbs7HqCdKl7VChqUVCNmxGTzBisK/uJLWby5UcKejKpINdEgpXQMORmhq4lKzOFvpCiFyr89OK4vULfUb6U7byaFc8LCSuPxHJr2aeGKSLa6gj0IrJfSYJI2ZY1H4VNncvnVjzbSIr7TpXW5vZrmFhwsrFip9iefwq/LBPqLhFRlizyT1NdA1kkcpBUVahiVSOKLCchmlWH2ZAK6CPpVOIAVZDVRF7krVXkNSFuKgkagaZBI1UpTVmVutU5DxSHcrSmqkh61ZlNVHNSxkDVE1StUbVIyCTpWVfPtjatSU8Vi37ZO38aAZx3iCTmOP3JNZCjC4q/rD774j0FUu4rpjpE5Ju8hj/AHqAuQaRjV/Srb7ZqVtb4yJZFU/QkZqiUrs9w8PweTptsn9yJV/IVuE8CqmmxBY8Y/CtBwAKxud7WpSlyfrVZ48jpVwrk04Q0iZ6GHcQcGsuVNpNdNcwfKeKwbuPaxpGJRNMc7UZvQZp5HNMkGY2HqMUITPO9UtmikVyOvNMjl32yqf4Qa6jXbJXsfNUZK1ycHDyL6LWxijrfCzbmU9+lehQHCj3FeaeFJMOuezV6VEf3Sn0oJkSfdnU+oqzVY/61D71ZpkhRRRQAhpKWkoAKQ0tNNMBpNNJpxFNIpAFMfpTqa3SgDL1D7hrh7//AF5ruL//AFZrh9Q4mNSzSmUm+7TI+tOY8UkZ5qUale8qpD9+rl5VOL79XEiZrwdKtLVSDpVtaoxLtt1Fa8HSsi261rwdKQmXEqQVGlSUCFozSUUAGaKKKYCUhpTTTSAKSikNAjpKKKKk0FpaQUUALmkoooAWikpaAFoNFFAADTqbRQA6ikzRQAtFFFABRRRQAUGimseKAKUiB9ysMhwRivM9f082ksqbeEkyv0P+RXqMgHyn/arnPE2nC5tPNA+YLg/0P54pMqL1PPtMwJyD+H17VutbrHqW0j5ZE6eorCtFC3Az0Jwa6b/Xi2l/5aRsI2/x/wA+tI0ZgX1t5E7f7LYJH86z7s71Unk9DXQ6xGEYkD7+CPyrnphzs7Ammg6FSQYAPpWp4S1k6D4mtbsnEJby5v8Acbg/l1/CqTxhgQfvdqpkYcZ+hqtxbO59TQyB1BByDzmrSc1xPw/1g6l4chjkbdcWv7mTPUgfdP4jH5Gu0RuKz2Zte6uWFOBSM+BTN2BWVq18YYtqnBNNsdODnLlRduGcr8oz9KjS5jitiJHVWPYmuSOpSjIWX9ay7rUH3cvn8ajm6noLA30bOiuJVeZmUgjNLHIK5SPU2Vupq7FqwBAahMxq4Zx2OpjkGBzVhZBjrXOw6nG38VaEN0HHBp3OVxa3NIvUMj0zzMionegENkaqsjVJI1VXakMikaqzmpZGqBjSZQxqjapDULnAqWUVrhgFNYd0SQzetatw2447d6zLsfKRSRLOTvdPll825UErnHSsp0KnmvSdMtEudDlBXJEhrj9asvs5aTGAScV1JnG92YOMg10vgeET+KLUEcIHf8lP+Nc6vAFdT4AITxdbA/xxuP0z/SnLYqn8SPbbRAEHFWWXjgUy1Hy4qwy5rJHb1KyxZarIhwOlOijwenWrG3ihIzqMyriPgisG+g68V1ksQIrKu7XIPFDMzjpF2miBd8yrj1/lV69tWUkgVStm8u6Qn1xSW4pbMxtQP7uaA9j+lcMoMd4ynvkV3eqxMNWCjo5/rXI61bfZNVxjAJzWpgix4dm8u72Z716rasJLcH2zXjenyGC4WXsrc16rodyJrMDOcCgUjXHMifnVmq0PLFvwqcUyR1JRRQAGkpaSgBKQ0tIaAEJpppxFNpiG01ulPprdKQGXf/cNcPqX+uNdzff6s1w2pf641LNae5nN0piNzT36VGn3qRqMujkVTi+/Vy56VTj+/VRIma8HQVaWqkHQVaXtVGJetuorXg6Cse26itiDoKQmXEqQVGnSpKYhaKSloAKSiigApppaaaBBSGiigDpKKSlqDQWikooAKWkooAWiiigBaKSloAWlptKDQAtAoooAWkoooAKKKKACm9qU0h6UARyLlPwqpcRiS3lUjgjNX26VTuPlgkI6qCBQCPK5YBbatLA3TcRn+tbdqhT5W/iBQ/UdDVPVoS+qzOvVAD9at204ZFkP+yD+B6/0qDboReIV2Txp36/pXMlN0n1OBW9qM/2y8kk/gUcfQVnRwlrmBCOpBP4mmC2Jr/S3Fskyg5AG7iuckXDMD1r1x9PSax4UEqPzHpXmuuWRtbxsDCk5H0qkJO51nw+1b7Dq1vubEF2ogl9nH3T/AE/GvZ424r5v8PzgTPAxwD8wI7EV71oOpf2hpcUrEeaBtk+vr+PWpkVB9DXkk2oTXC6/rAR3YtwK7dgHXBrldZ8N2rSidwzqx5QnjNRLU78G4qfvHnQ8TSPO4jtJZIu0i/4VHNrFxIp8u0m3dtycV3LafHHGqpGqjOAAKYLLcSoXp7VOx7Kp3WrOHN/dmLG10cjrs6H2qKG51dJCXkMiejR4P6V3X2BW3FtoUAmqV7DDG/yc/h0qjKVGN9zml1LVFGfsgPPZ63fD95rU96izW0awHgnfkj9KjWLe+AOPSuo0aD7MAxHzGhHDiIwijVUMq80x2xU8kgIqnI3Wg88jkeq0jU+Rqrs1K5SGMajNOY1GxqWUhGPFVZn7DrUkj1AR60hldxgVQuRkGtJxxVGdcg0Illzw4Q9hdQdw4OP8/SsHxrCsbQxpjLc1seHHMeoyx9nX/P8AOszxEn2vxHBAOi8frXQnocbXvHLNpciopweR6Vp+G4ZLDxFp9yQQqzAE+zfKf511o0pZXQBeAATT5NJVFJC4PRfpVApWdz0a19KuhNxwOtYuk3RuLaOQ/eI+b6963YTxWaOty00JUjCj3pSKkUcU1hVGTIioNVpoQR0q2aY4yKGBgXlqGByK5e7h8uYjHFdvdIMGuV1aPD7qzZZz0ymbVbZWGSDnPqKxvGdntZJwOQcGumhjU3ccjDlc4P1FZXi11ezZT36VrF3RzSVpWOO0lFuHniPcZFdf4SvWAe2Y/Mp21xOnSeTqC+jHaa6WBzpesQXHSKY4b2piaPSohtUVNVe3kEsSsOhFTimQLRRRQAtJRSUAFIaWkNACGkoJpM0xBTG6U+mN0pDM2+/1ZrhtT/1xrub7/VmuG1P/AFxqZGlPczW+7UafeqRvu1Gn3qk1GXPSqcf36u3PSqSffqokS2NWDoKtrVSDpVpasxL1t1Fa8HQVj2/UVrwdBSEy8lPqNKkBpiFopKWgApDS0lAhDSUpppoAKQmg0lAHS0UlLUGgtFJS0AJS0hoFAC0UlFADs0tMzSg0AOozSZooAXNLmkooAWikooAWikooAU9KSg9KKAA9Kp3bBYyfzq5WNrVz5Ns5HJxgfWkxrcwbe1F3Jez44J2r+FYU263laJTxnH0rp2lj0rRlDnMjDp3LGsrS7B765e5lBManczHoT/8AWpWNEyjJB5NqIiMPKwHPYCjSbY3Oos+Mqo4/pUmozCS7YL0jUgf5+tbmgWfkRKSPmI3GhA3obVod0Cjsyg1y3i3ShLavIgy0f6iurtVKxbf7jECoNVgDwScZBU0yE9Tx2xk8i/Ru2cV694Vv2t13ZynRxXkl9Cbe9dR/C3Fej+EJhPbHnqoNN6lPTU9QilDoGU5BGRikuYhcQFD36H0rH067MDiJz8hPB9DW4vzVm1Y2hPaSOXu4ZbdsMDgdD2qg93IpJDHJ64rtZLVZR0qq2hq5yEX8qmz6Howx9laSOKknduBkn6VX+yTTN9w/jXef2AQOgpj6MF60crFLHt7I5S0sRCckZatWIFRV9rBY+1RGLb2p2Zxzm5O7IyxxVeRqmkOKpyNQyURyNUDNTnaoWaoZaQE1C70O/pUdIoTqcmkIp1BFAiBxVSVcg1dcVWlXimiWVdObydVjb1yKjdPN8XOx52g0rZSeOQfwsKntE369LJ6itoPQ5qi1OmghAhLY5NSvGH2jHapIwPIwB2p+wFB+tWYhpbm2mCn7jn8jXWW54FcoUyBW/pdx5sIVj8y8GpaN6ctLGynSkYUkZzUhFBRARTG6VKwqJ6BlK5HBrm9Uj3Ia6WcZBrEvkyrCoZSOYORyOorK8RKHsWI7itmVNrkVl6qoawkB7DIpwfQzqLqedhSGLDqDmuygRdW0Yj+PGQfeuWEf71weh4ra8M3Xk3LWzHgnirM2dj4T1I3Nj5Mp/exfKwPtXTZrhISdK8RI44hufyDV20TblBzTIZNRSA0UxC01jilpCKAEU5FKaKKAGmk4pSKTFAgpj9KdTWoAzr3/AFZrhdU/1xrur37hrhtV/wBcamRrT3MxulRp96pG6VGn3qk1Euvu1RT79Xrn7tUF+/VRJma0HSrS1Ug6CrS1ZgXbfqK2IOgrHt+orYg6CkJlxelPpi9KfTELRmkpaACiikoEBpppTSGgBKSlptAHTUUmaM1BoLS00UtAC0UmaM0AFFJS0DCikozQA6lFMzTgaBDxRSZozQAdKWkpOnSgB1FICDS0AFFJQSAKAGyvtT3rlNTu45L3Dt+5g5b3PYVd17WUsotikGZ+FHp71laZoc18VnvtyQZ3CM8Fz6mky0rK5HbWlxr12J5QUtl4X6eg/wAa19Uli07TvIjCqoGMCtR3jtLf5VCqowABXIXbS6tfhE+5nk+g/wA/rQPcg0exa9nM8i/IXzz3rrbGLBLdmOR9O39aihtFtrYQxjbxsHtWhbx7VJ7dB9BQS2IF2TMOzYP9KW5TfbuMdOadIOQ3oac3MbD1FMR4/r0O3UH+tdJ4Dm2vJEeo6Vj+IlH9ryJ6mrvhVzb6pF2D/KaRo9j0gitfTLzdiGQ/MPuk96yqTJUgqSCOQabVzOMrM7CLBNXE2gVh6dfi4jwxxIvUevvWiJuOtStDo3LjSKBiqczAimPNjvVaWehspRIrgis2ZutWJ5hg81mTzCpbKsRyvVKR6WWb3qLy3f5iMCobGkRM2ahZjU7R4qJkqSiKgU4rS4oENxRinYoIpgQuKgkFWXqBhmgRnzr8mKv6VCTeRP3ZDn8KrTL0NaOifM+f7hI/CtIGFU3oOVUGpwO1RxKNx+tS45xWpgNwQc9qs2Upt7lSfung1FjNIR2oBOzudXC2eatdRWTps/mwLk/MODWqp4qUdF7jGFQOKtMOKryChgUphxWVdpkGtiUVm3K5BqGWjl7uPDZrLu4RNBJGf4gRXQXcfWsiVME0kKRwItjunVlww/nTRmCaG5XgHrXQanaiOYzAcOMH61nQW32nS5Ux80bHFaoxZv3sf9oaMJo+ZY8OpHqK6DQ70XmnxSZ5xzXMeFrrzrV7d/vLxitHQGNnqFzZHhVbK/Q00Qzq6KSlpki0UUhoAKKTNJmgANNNKTSUxBTWp1MbpSGZ979w1w2q/wCuNdzefcNcNq3+uNTIuG5lnpTE+9Tz0qNfvVJsFz92qC/fq9cfdqiv36qJMjVg6CrS1Ug+6KtpVmBct+orYgPArHt+orXg6UhMuqeKfUadKfTEOFLTaM0ALSUZpKACkNFFAhKQ0UlAHS5opM0ZqTQXNLTaWkAUUUUAOpDRmkJoGBNJmkpRQAop1Npc0AOpabmlyKBC5opM0ZoAXGaT5h70ZqOWdIULOwUD1oAfvA6gj8Kx9T1gxv8AZbOMz3TdEXovuT2pZZrrUPkgzDAespHJHsKs2dhFaJtiXGeWc8lj7mkVsZenaDsn+237/aLtjn/ZX6VuHCLubAA7UrvHCpZjjHc1jXlzLeMYogQvcn+v+FAasqaneSX032e3Py9z7etXtM09LSLdj5upOOppbOzWMfKMnuT3NX3OxQi8kn8zQkDfQiAJkJ/ujH4mrqjagUdhUSJtUDrg5JqXPBpiGtycUxjiJvanj1qvfSiG0kc8YU0gPNdcxNrchHPNXNOhaJ4JhxiTFU4Ua81NpMcFjmuhWALZxMB/y0zSNGzs0O6NT6ig1HbnNtH/ALop5qzIRJXhkDocMK17fVEmXDfK46isgIXbArTsrXy8HHNRJ2NqSfyLD3if3h+dVJb5AD8w/OtlLeKQDzIkb/eUGpBZWy8rbxD6IKjc3vY5R7l5jthR5D6KM0qaTe3BzJiFf9rk/lXWFABgDAqMrSsHMYCaTFAMgF2/vNUU1t7VvvHmqssIPalYaZzskOO1VXix2rcmg68VRliqbFXMspzSbatvHURWmIhxTSKlK1GwoEQvUJFTPUZoEVpF/QVb0I4unjPcVAw60WL+Rfxt2JwauDszOoro6xF+VT3xipMcZFNQ8frT+h9q2OUM/nSHJ9qdgGk5FAFzSpfLuTGTww4+tdJGeK5CNzHKrjqpzXVQOGRSOhFJm0HdWLB6VC4qYcimOKCylKKoTr1rSkFU5l4qGUjCuo85rFuEwTXR3KdaxbqPk8VIzFuIVljZGHBrJ0uLyLu4gcY3cit2VazbqMpKlwvVev0qoszkjMtQdM8QMnRZORW5dH7NrNrcrwJRsP8ASs/W4gUt7xP4WGfoauXjedpMc38UTK1WZHXod0YPtTgaq2MnmWcbeoFWqogWkNFIaAEpKUUppgMNFBNJQAtNbpTqa3SkBn3n3DXDat/rjXc3n3DXD6v/AK41Mi4bmSelRr96nt0qNfvVJsFx92qK/fq7P92qS/fqokyNS3+6KtrVS3+6KtrVmBct/vCteDoKx7fqK2IOlITLqdKfTF6U7NMQtLTRS5oAKKKSgQGkoNFACGkopKAOjpabS1JoOpCaKQmkAuaM0ylBoAfmmk0ZpKADNOBphozQMfmlBpgNOBoAeKKbmjNAheKOKM03ljgDNAEcsjD5Y+W9SeBUC2is4kncSN2z0H0FXRbSn/lmfxFKbab+5/KkUk+xCHjXqy/gaY9zgYRSfc8CtCHTBPgPcxRsf4WJqS48PXFv95VOeh9ae4Wtuc86PO2XkGPRaljtwAAF2r6VpnTpV428/Wo3s5V6ox+lKwEGRGAAMnsBSxoQdz8sf0pVAU4UHNOBzTEFO9qbQDSAdXN+KL/yrbyEPzPWvf30dlbtI5+g9a5GCGbWdRMsgOzOT7D0oKQ/SrHyLN7hxgkcVreVi3jT0AP6U+4Vd0Vsg+UHLfSr0No8iEkYyO9JtFKLZbteLaP6VOiM54FPtLbMa57CtGGADtUufYqNLqxltbBecVpRR47UkceKsotQbbEka8VKBTVFPqkSxjDioiKsN0qBuDQIjIqF1qc9KjagZQlT2qhNHWtIKpTIKkpMyJI/aoSlaEkeahaPigCg64qu9XZVxmqUlAFdqYRUjUw0ARkZqGQEcjqKsEcVE44pCOm06cXFmj98c1b7Vzuh3XlTtbseG5X610VdKd0cklZ2DOOtFJRTJA10Gly77NPVflrnzWposmGkjPs1Jl03qb46UMKRTxTjSNitItVJV4q+4qpKuaTBGVOlZF1H1renXrWVcpwahlnPzpyapSL1Fa1wnJrOkWkJmZcL/oU1s3TaSlLbt5mizKf7lS3cReI4+8OlU7EkadOp4IUitE7mMlY6vRW3adEf9kVp1keHznS4vpWtVmTCjNFJQAtIaKQ0ANpaSimIKa3SlpG6UgKF59w1w+r/AOuNdxd/cNcPq/8ArTSkaQ3MhulRr96pGPFRr96oNhJ/u1SH36uz/dqkPv1USZGpb/dFW1qnb/dFW1qzAuW/UVsQdBWNb9RWxB0oEy6vSnUxTThQIdS02loEFFFJmgBDRSZozQAUhozSGgDoqKSlqTQWg0UhpAJS0maTNAx9ITSZozQAZpM0GkoAeDSg00UtAh1SRRSTPtjUk1NZWL3bZ5WMdTXQQWqQIFRcCk3YuMLmZBpIGGmbJ9BVwW8ca/IgH4VcIqF6l6m8YpbFVwBVWQ4q3KeKoTNUsshdsGuksbgXWiqJPmKfKQe+On6VyrtWz4em3w3UHcAOB+h/pTg9SKi90r3UghkZUkPXIGOabaSGaYLucHvkUl6jLcB1ByByCMVILtJYliUeSxPIAyp/wq09TBrQs3n2aDjJaQZw3tWLfAPE1xGBuX7wHcVZvWeAgMpGANw9aCirHhV+WQA4FNsLGOl0jjINJJMwX92u5vyqrLGba6aM9M5H0qdU3cgkVk5s3VKL1M2TRrnUZ/Mu5gqdkXnFacdlDY2+1CFUDsOtBaaMZ27h7VUluGuZBGQVQH5vf2pczL5Eixp1r5sjTsOCfl+lbaRBRkCqVtMqoFXpV+NwxHpU3uO1i1FGAoGOgq1GvaoI2Bq3HTSEydEqZRimRnipQKqxNxwFKBQBThTFcQjiq0lWj0qtLQwRDmmmmlsGjdSAY4zVWRc1bPNRsuaLFIoNFmoJI8DpWp5XtVa4TApBcw5xjNZ8nWtK64JrNfmkMgbrTTT2FR0CA1G4qSkYUAVTuRw6nDKcg102m6gl5CATiRRhhXOstRpJJbyiWJiGH61cZWM5wudpRWdp+qxXihWO2UdRWjWpztWEq1p0nl3yejZFVaFcxyK46qc0AnZnYRnipR0qtA4ZFI7irApI6GNYVXkWrTDioHFAIz5lrNuErXlWqE6dahlIwLmPrxWZMmCa3blOtZM6YqRszXFUnQRJcY6OpP41oyLVS4jEkbKe4604uxnJXNjw/wAaZF9K16ytFXy7CNM9BWpmtjne4E0lBpKAFzTSaU02gBaQ0ZopgJSN0p1NakBRu/uGuH1f/Wmu4u/uGuI1j/WmpZcNzGbpTFHNPamoeak2Gz/dqkPv1dn+7VH+OqiTI07f7oq4tU7f7oq2tWYFy36iteA8Vj2/UVrwdBQJlxakFRLUlAhc0uabmjNACk0lJmjNAhaQ0UhoAQmkzRmigDoqKKKk0FoJpKaTSAXNFNpaAFpaaKXNAwopKWgBwq3YWbXk+ORGvLGqqKXdUUZJOBXW2FottAqDr3PqaTKjG7JoYVjQKq4UDpUu2pFWnFcClY2KrCq8gq44xVWUdaLDuUZaz5j1rQmPWs6bvUsq5TkPWrmhXHk6sgP3ZAUP9P1AqjJ1qNJWhmSVfvIwYfgaSdncGrqxvavG0UhYcDOePSs2NXf7g3Nn8a3tXQTQb16Fdw/nXNBih3LVSWphHY2pIDdaZtY5njyeeuPSs61kaSIwN1B4PtSW90yvuUkPSzTKk5YKE5IIWne4rFfXbLZCs68lDtbHp/8ArqjZyhlA6n0rYnY3NhNGqFwUPJOMGuXtJjHOpz3qJLU3pvSx0H2SSUc/KPQdfzpDpS7cba0rBxJGtaIgDDpRylcxyjWMsRynI9KdHO8ZAYEV0z2o9Kqy2CsOlTylXKUF0PWtKGcEdazZNO2nK5H0pipPCeu4UA1c6KOQetWFcGueivGXG4EVdivQe9UmS4myGFOBrPjulPerCzA96dyGiz2qtNUqyAioZz8tDBFJ25pFaopH5pEfJpIploCnBM02M5qwq5xVWJI/L4qldrgGtbZ8tZeoHappPYaOavD8xqgRVu6OXNQrHxUFMqutQN1q5MuKpvTEKKMUgNLQIYy1C61YNMZc0DKZ3IwZSQR3FbFhrpXEd1+D1mMtRMntVKViJQTO1jlSVQyMCD6UNXH291PaNmNzj07VsW+uRuMTAo3r2rRSTMJQaO60uXfZx88gYP4VqKciua8P3kc8ciI4bBzwa6OM8UGid0SEcVE4qamOKYylItUplrRkFVJVqGUjHuE61k3EfXit6dKyrhOtSyjElXGarOtaE6VSdaQmTadc+TL5bH5W/Q1uZ4zXLsMVrWF75kex/vL+taRl0MJx6o0s0ZqEXCZwTg08MDyDmrMxSaSkpaADNGaSigAzSE0UhoAp3f3DXEax/rTXbXf3DXE6x/rTUsuG5it0pinmnt0qNfvVJsLN92qP8dXZvu1S/jqokyNK3+6KtrVS3+6KtrVmBbt/vCtiDoKx7frWvAeBQJlxafTFNOzQIWikzS5oAKSlpKBBSUpptABSUZooA6KkooqTQWkNHSkzSAKKKKAFFFFFABS0lFAzW0S3824MpHCdPrXURrWXpEHlWSZHLfMa2YxSNoqyJFWhl4p6imv0qguVpBxVKU1ckNUpT1pMaKM1Z03er8xrPmqGUinJUD9KnkqFulQy0dWh87SICe8Yz+WK5r+Ig10Ni27RYPYH+ZrBYfvnHoTVy2Rgt2ES/OCvUHj3pu5Scv09PU1JLE2BsU7gQMdz6VWnYrJtx0/n3pbAalrNmJRwenT0rj5l8q6df7rkfrXTWkn7sKPWue1Jdmp3A/2yfz5olsXT3N/SLjKqM109u25RXD6VLggV19lLkCnEqRpbM9qY0QPapk5FOxVWJTKEkA9KrPCPStR1qq681LiUpGY9uPSmeTjpWgyCoylS4lqRWVSO9SqzDoadspQtKxVwFy6d8083iuuCeagkXiqErFTS1QrJliWT5jzRE/NUTKT1NTQvzTRLRsQnNXYxWbbtWhEeKtEMnbhawtUkwDW27YSud1MlmIFKY4IwWG+U1ZSD5elSQ2pByathABjFSkUzHuIsZrMlGDXQXEWQcVj3MRB6UAUs04GmNwaQGmSS5pppm+l3UABWmFafmikBCUppjycYqxip7K3866VccDk00D0N3w3H9kuol6b1IP16120RrjISYr2Nh/CwzXYQngVoZxdy2p4pGFC049KoCs4qrItXXFV5BUsaM2ZazLhOtbMq9azp0zmpZZhXCdaz5Fxmtm4TrWZMlSBRcVFuaNgynBFWHFQMKCWP3s4zuJp6TyxH5XP0qBTtPsakNMVkzRg1EMQso2n1rQDBhkHiucNWLW8aBtrHKfyq4y7mcodUbeaM0xHV1DKcg06tDIWkI4ozSE0gKl19w1xGs/6w1210fkNcTrH+tNSy4bmK3So161I3SogfmqTYdN92qJ+/V2X7tUj9+qiTLY0bf7oq2tVLf7oq0tWYFy36iteDpWPb/eFa8HSgTLi0+mLTqBC0CkpRQAtFJRmgAJpDQaSgQlFFJQB0eaKSlqTQQ0lLSigApDS0hpAFFFGaACpIEMs8cf8AeYCoqv6PH5moKf7oJoGldnVwLhQB2q7GKrRDirS0kbsl7VG5p2ahkNUSQSGqUpq1IapzGpZRSmPWs+U1emNUZahlIqPURFSvUZFSUjo9NJOkQ49WH6msR/8Aj4bHqa3NKGdHUc/eb+tYkv8Ax8OcfxGreyMerFaaUKATxjH4VUlX5sj0q/JEZLYyqCQnDcdPQ/jVLB24oYIfZt8qjGeay9aTbqbn+8qn9BWpZDHGO9VPEEe27hfGN0Y/QmpexcPiKdi+2TFdZYS8CuNgO2QV01hJ8ooiXI6iGTirGcisyCTgVbV+K1TM2SmomFSZpp6UCRAy1GVqztzSFKVirlcp7VGy4q0VqNlpNFJlR+lZ1wtacgqnKuahotMzSCDUsOQae0fNORMUgLkDVoxPxWbFxVyNqpEstO+Vqk1r5jZIq0DmpOAKNw2MuSAJ2qswwa0pxmqTLzSKKrpuqpNaB609tIY6dhHOy6Vu6cVVbSpR0Oa6oxA9qaYR6UhHJNp1wO1M+wXP939a60wD0qNoQO1AHLixuD/CBUq6fL/ERW80YHaoH4oCxmixC9TmtTTrQRxtIBjsKh2l2AHet7yhBAkY64qoLUio7KxXt7YMWkfrXQWzZjX6VmxR+VDubBJ6VdtGOwZGOatmcDSTpT+tRRmphQUyNxVeQVaaoHFDBFGVaozJWlItU5V61LLRjXCday5061uTp1rLuE61IzJkWq7irsq4qs60hFZhT42yMHrSMKZyDkUyWSmmmnA7hmkNAyzY3Rhk2MfkP6VsZ4rmzWxYT+bBg/eXitIPoYzj1LeaQ0UVRmVLofIa4rWP9Ya7W6PyGuJ1n/WGpZcNzFbpUY+9UjVGv3qk2CX7tUj9+r0v3aon79VEmWxo2/3RVtap2/3RVtaswLdv1FbEHSse3+8K17fpQJlxadmmrThQIWlptLmgAooooADSUGkoAKSiigR0OaXNJSZqTQdmjNJmkzQA7NJSZpM0gHUU3NLmgBa2fD8eZZZPQAVi10egR7bQv/eY0nsXDc3ohxVhahjqYU0asUnioXNStwKgc0xIryVTlNWpKqS1LGUpapSVdl71UkHNQykVHHNRkVM4qMipKR0GlD/iTjuAze2Px/z1rFkH70/Wt7SONFYjPDP069KxxH5l0qepxV9EYvdiQEB8OMofvDPUUktqY3cj/VlS6t6inwLmUI3JPH41JPvhsSkgIJb5QewHX9cU0Iz7Xh+fWneI482drLg8Myn06D/Cltl5PFWNbj36IGAHyOpz+f8AjS6MpfEjlFOGFb2nyfKKwa1dPfpURNmdNBJwKuo9ZUD9KvRtWiMy6rcVIDnrVZW4qRWp3FYlpccVHv7d6eG4pjENROKlPNMakBVdc1WdKusKhZaTRSZSMfNASrBWjbU2HcYi4qdTTAKdQBKrYp+/ioN1GaYhZDmq7DmpGYVExpDuN4pCaQmkzTAcKQkCmk00tSEDNULE04800igCFqhKZNWttHl0hj9LtPOvFJHyp81as6Ayke9LpEXkwSTEdeBU0UTTS9RgckmtYrQwm7sjgU+ZjBOeBVjCxTmNTkgc/WpJEW2OUIPHWqqKVkDn+POBTewo7mjGanFVozVhTxSRbFNQuKmNRvTEVHFVZVq64qtIKllozZ161l3CVszLWdOnWoZRizJVN1rUmTrVCVaQik4qI1YdagYUCYiNtOD0NSGoDUiNkYPWmIDU9jL5VyB2bioDTckEHuKE7MTV1Y6M0xmpIX8yFW9RQwrY5ypcn5DXGawf3hrsrkfIa4zWP9Yallw3MY0xetPNMXrUmwS/dqkfvVdl+7VI/eqokyNC3+7Vtap2/wB0VbWrMC3b/erYt+lY9v8AeFa9ueBQJl1adTAadmgQtFJRmgBaKSigApKKKACkopKAOg3UZqLdRuqSybNFRh6XfQA6im76NwoAdS0zcKNwpAOzXX6THssYR/s5rj1+Zgo6k4rubVNsaqOwApM0pl5KlFRL0qUU0WxGPFV3NTPUDmgEV5KqS1aeqslSxlSSqjjmrclVnFSyiswqMipmFMIqSkdDpoA8PnPUliOPzrIi4vkJ9c1s2+Y/D0a44b3/ANo8isdI3kuoxEPn3ACtOxg92XLC1MjebIo2B8ZPrVTVpTJeOpx8vHFbkrRphFAwmc+1YFwrTTNKxyxOD7mqasrEp63ILYYI+tac8H2jSJ4z12Ej6jkVnRDDY962rQ+vJIqYjb6nnpFXLJ8Nik1G2Nrfzw9lc4+nb9Kjt22yCslozp3R0lu3Aq/G1ZNs+QK0Ymq0QXkapQarI1TKaoCXring4qMUueKBEmaa1JmgmmA1qjYVIaaaQyIimEVKRTTSAjozSmmmgYZppNKaYaAAtUbdaU000DEpDS0YoENNNxUmKTbQBHil21IFpwSkBEEzT1j5qUJVm0h8y5Re2cn6UWAu7BDaRxAdsmmEmOMYGM8mpZWLTtkZUfpT7xojKPLHybQOlbHMQBBJAo6F2x+HU1Az+dett+5ENo/rV0KEiWRuFRGOffP/ANaqdkmI93duamRcFrctxHpVlTVSM4OPSrK0kWyWmN0p9NYVQiu4qvIKtOKruKTGilKtUJ0rTkFUplqGUY86daz5VrXmXrWfMvWkMzJFqu4q7KtVXFIRXIpmdpzUjUw00Sx+cjNNNIpwcUpoA2NOfdaAf3TirDGqOkt+7kX3q89arY55blO5PyGuM1j/AFhrsrn7hrjNY/1hoZUNzGNNXrSmkXrUGwkv3apn71XJfu1SP3qqJMjQt+gq2tVLfoKtrVmBag6ite36VkQdRWtB0FAF1elLTV6U6gkWiikoAWikooAXNJmkooAKSikoAs/2ivrS/wBop61yP2x/Wj7Y9Rc35Drv7RT1o/tFfWuR+1vS/a39aLhyHW/2ivrS/wBor61yP2t/WgXb+9K4ch139or60v8AaK+tcj9qf3pftT+tFx8h3Wk3IutUt4gc5bP5c16LCMAV5R4D3XGvlm6RxM345A/rXrEPSlfUqMbItLT80xacaoBrGoHqVqhegCB6qyVZeqz9TUsZVkqu9Wnqu4qWUiuwqM1K9RtUMtHSZ2aLap83IHA75z/jUelW4iEt446HaoP6n+n41ZukZbGGMAjai4PuABUcrbIUtwc7R19fWuixytmdqVwckIPmlbIHsOtVjmRRJtxkZ+uK0BaJJ+/nHA4QHpj/AAqOaNB92UMmeeCCDj/69FhGYARISfWtW2OAnHXIrN2jcV7g9a0LdvlXPqMUkNmR4rsWWSK9VPkYBHIHQ9v0/lXNqcMK9JntkvbOW3k/jG36f54rz27tJrK5aCZCrqfzHY/Ss6kbO5vSldWNKzkyorVibpXP2cuDjNbUL8CkmNmghqZTVWNuKnU1QicGng1EDTwaYh+aXNMBpc0ALTTS0lADTTTTzTDQMYRTDUhFMIpAMNNNPIpuKBjMU3FSEUmKAGYoAp+KUCgBm2l208ClxQAwLTwPalApwFIAC1e09Npkk9Bj/P5VVArSgXy7E+rnj/P51UdyZv3RsQ3ykMfc+5o+zyyHgHGeSadakCYl++RRPNJv6bUPVfatDDqVdRuAtqLdTknCg+uT/wDrqWFNkYA9KqXUfmS20uODIR+h/wAKvDpWb3NorQjHEhqyhqs/EgPqKnQ00Nk46UhoFBqiSNhUDirDVC4pMaKkgqpKvWrziqsi1LKRmTLWfMnWtaVaoTLUjMmVKpyLWnKlUpVpAUXFQmrMi1AwoJIzTs5FNNIDiqEaelH55BWi/SsvSz++f6Vpv0rSOxhLcpXJ+Q1xusf6w12Vz901xms/6w0McNzFakXrSt0pq9ak2Fl+7VI/eq7L92qR+9TiTI0LfpVpaq2/SrS1ZiWoOorWg6VkQda1rfpQIuLT80xadQSLmjNJRQAuaM0lFABRmikoAXNNpaSgDmNopdoqPJoyawO0k2ijaKZk0uTQA/aKUKKZzS4agB+FpcLUeGpdrUgO8+HMINxezY6BVH45P9BXpUVcL8ObfZo88xHMkx/IAf8A167uMcVSEycU6mrSnpVkjG9qhfvUzVA9AEL1WfrVh6ryVIyu9QOKsNUD1LKRWei3j867ij/vOB+tJIeataIvmaoh/uKW/p/WpWrsU3aNzqL1gtuuVOWbr7dayHAJySRk5P0q7fzebJgdFBGB60toqx20rsvzDv7dP610bs5OhHcIk0aLET8udoyOR2x7/wCNZ8sflwSyOfnbAAyCfWtGdI0gGCCASwwOp96yJiWUlg3P6+mP1oYIrKSwXA5PWtGFduFPYZqpFG3mAdAoxWhAuDk9Ac/hSQ2WkIXbzjcPyqrqukDVrUowCTxD5GxwD3B9j/n0q4Yzgc5DVLH1wQc/rTtfQSdndHmRSS1uGjlUq6HaynsRWtazAgc10mvaCmpw+fCAlyi9cY3gdj/j/SuLjMlrO0MqlWU4IIxisXFxZ0xkpI6GJ6tI1ZdvMGA5q9G3vQhlsGng1ArVKDTESg0ZpgNOzTEOBopAaKAA0006mmgBpFNIp9IRQMjIppFPNIRSAZijHNOxRigY3FKBS4pcUAJilApcUoFAABTgKAKeBSAAM8Vozny4o48Z2j9ar2UJluBxwvzGprgHzjWkVpcyqPWwiqwiB6Fun1pZ1MsSuOXJwQPWn3GI4ohnkdfY06H5nZyAVI+ZfWqMyjdMV8iMjDJJg/kf8anB4qC/BkieQtmSLDZ/vKO9SK4aMMOhqHuaw2CTqpqWM9Khc5X6VJGeKSKZZWlxTFp9WSMIqJxUxqJ6QFZxVaQVbcVXkFJlooyrVGZetaUgqlKvWpGZcq1RlWtSVetUZlpAZsi1WcVelWqsgpCKxppp7CmU0Sy7pZ/fsPUVqt0rCtZPKnVu3etstlc+tax2MZrUq3P3TXG6z/rDXYXB+U1x2tf6w0MIbmI1IvWlamr1qTUWX7tUz9+rcp+Wqh+9TQpF+36VaFVLfpVpasxLcHWtaDpWRB1rVt+goEXV6U7NMFLQSOzRSUUALRSUUALSUUlAC5pKSigD/9k=";
        String savePath = "test.png";
        ImageUtil.base64ToImage(base64Image, savePath);
    }
}
