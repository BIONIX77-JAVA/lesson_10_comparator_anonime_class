package com.company.Bionix.print;

public class BaseOnStudentConvertAndPrint {
    public interface IStudentStringConverter {
        String convert(BaseOnStudentConvertAndPrint student);
    }

    public interface IStudentPrinter {
        void print(BaseOnStudentConvertAndPrint student);
    }

    private int id;
    private String firstName;
    private String lastName;
    private int groupId;
    public String faculty;
    private double averageMark;

//    public BaseOnStudentConvertAndPrint(int id, String firstName, String lastName, int groupId, String faculty, double averageMark) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.groupId = groupId;
//        this.faculty = faculty;
//        this.averageMark = averageMark;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getAverageMark() {
        return String.valueOf(averageMark);
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }


    public BaseOnStudentConvertAndPrint.IStudentPrinter consoleJson = new BaseOnStudentConvertAndPrint.IStudentPrinter() {
        @Override
        public void print(BaseOnStudentConvertAndPrint student) {
            System.out.println(converterJson().convert(student));
        }

        private BaseOnStudentConvertAndPrint.IStudentStringConverter converterJson() {
            BaseOnStudentConvertAndPrint.IStudentStringConverter jsonStudentStringConverter = new BaseOnStudentConvertAndPrint.IStudentStringConverter() {
                public static final String COMMA = ",";

                @Override
                public String convert(BaseOnStudentConvertAndPrint student) {
                    StringBuilder sb = new StringBuilder("{\n");
                    addJsonRow(sb, "id", String.valueOf(student.getId()), COMMA);
                    addJsonRow(sb, "firstName", student.getFirstName(), COMMA);
                    addJsonRow(sb, "lastName", student.getLastName(), COMMA);
                    addJsonRow(sb, "groupId", String.valueOf(student.getGroupId()), COMMA);
                    addJsonRow(sb, "faculty", student.getFaculty(), COMMA);
                    addJsonRow(sb, "averageMark", student.getAverageMark(), "");
                    sb.append("}\n");
                    return sb.toString();
                }

                private void addJsonRow(
                        StringBuilder stringBuilder,
                        String propertyName,
                        String propertyValue,
                        String delimiter
                ) {
                    stringBuilder.append("\t\"")
                            .append(propertyName)
                            .append("\" : \"")
                            .append(propertyValue)
                            .append("\"")
                            .append(delimiter)
                            .append("\n");
                }
            };
            return jsonStudentStringConverter;
        }
    };
    public BaseOnStudentConvertAndPrint.IStudentPrinter consoleXml = new BaseOnStudentConvertAndPrint.IStudentPrinter() {
        @Override
        public void print(BaseOnStudentConvertAndPrint student) {
            System.out.println(converterXml().convert(student));
        }

        private BaseOnStudentConvertAndPrint.IStudentStringConverter converterXml() {
            BaseOnStudentConvertAndPrint.IStudentStringConverter xmlStudentStringConverter = new BaseOnStudentConvertAndPrint.IStudentStringConverter() {
                @Override
                public String convert(BaseOnStudentConvertAndPrint student) {
                    StringBuilder sb = new StringBuilder("<student>\n");
                    addXmlRow(sb, "id", String.valueOf(student.getId()));
                    addXmlRow(sb, "firstName", student.getFirstName());
                    addXmlRow(sb, "lastName", student.getLastName());
                    addXmlRow(sb, "groupId", String.valueOf(student.getGroupId()));
                    addXmlRow(sb, "faculty", student.getFaculty());
                    addXmlRow(sb, "averageMark", student.getAverageMark());
                    sb.append("</student>\n");
                    return sb.toString();
                }

                private void addXmlRow(
                        StringBuilder stringBuilder,
                        String propertyName,
                        String propertyValue
                ) {
                    stringBuilder.append("\t<")
                            .append(propertyName)
                            .append(">")
                            .append(propertyValue)
                            .append("</")
                            .append(propertyName)
                            .append(">\n");
                }
            };
            return xmlStudentStringConverter;
        }
    };

    public BaseOnStudentConvertAndPrint.IStudentPrinter consoleSimple = new BaseOnStudentConvertAndPrint.IStudentPrinter() {
        @Override
        public void print(BaseOnStudentConvertAndPrint student) {
            System.out.println(converterSimple().convert(student));
        }

        private BaseOnStudentConvertAndPrint.IStudentStringConverter converterSimple() {
            BaseOnStudentConvertAndPrint.IStudentStringConverter simpleStudentStringConverter = new BaseOnStudentConvertAndPrint.IStudentStringConverter() {
                public static final String COMMA = ",";

                @Override
                public String convert(BaseOnStudentConvertAndPrint student) {
                    StringBuilder sb = new StringBuilder("{\n");
                    addSimpleRow(sb, "id", String.valueOf(student.getId()), COMMA);
                    addSimpleRow(sb, "firstName", student.getFirstName(), COMMA);
                    addSimpleRow(sb, "lastName", student.getLastName(), COMMA);
                    addSimpleRow(sb, "groupId", String.valueOf(student.getGroupId()), COMMA);
                    addSimpleRow(sb, "faculty", student.getFaculty(), COMMA);
                    addSimpleRow(sb, "averageMark", student.getAverageMark(), "");
                    sb.append("}\n");
                    return sb.toString();
                }

                private void addSimpleRow(
                        StringBuilder stringBuilder,
                        String propertyName,
                        String propertyValue,
                        String delimiter
                ) {
                    stringBuilder.append("\t")
                            .append(propertyName)
                            .append("=")
                            .append(propertyValue)
                            .append(delimiter)
                            .append("\n");
                }
            };
            return simpleStudentStringConverter;
        }
    };

    public BaseOnStudentConvertAndPrint.IStudentPrinter consoleEmpty = new BaseOnStudentConvertAndPrint.IStudentPrinter() {
        @Override
        public void print(BaseOnStudentConvertAndPrint student) {
            System.out.println(converterEmpty().convert(student));
        }

        private BaseOnStudentConvertAndPrint.IStudentStringConverter converterEmpty() {
            BaseOnStudentConvertAndPrint.IStudentStringConverter emptyStudentStringConverter = new BaseOnStudentConvertAndPrint.IStudentStringConverter() {
                @Override
                public String convert(BaseOnStudentConvertAndPrint student) {
                    return "";
                }
            };
            return emptyStudentStringConverter;
        }
    };

    public IStudentPrinter delegatingStudentPrinter = new IStudentPrinter() {
        @Override
        public void print(BaseOnStudentConvertAndPrint student) {
            consoleJson.print(student);
            consoleSimple.print(student);
            consoleXml.print(student);
            consoleEmpty.print(student);
        }
    };
}