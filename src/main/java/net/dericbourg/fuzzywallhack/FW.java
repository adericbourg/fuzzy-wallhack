package net.dericbourg.fuzzywallhack;

import net.dericbourg.fuzzywallhack.api.GenerationConfiguration;
import net.dericbourg.fuzzywallhack.descriptors.*;
import net.dericbourg.fuzzywallhack.descriptors.type.StructureType;
import net.dericbourg.fuzzywallhack.descriptors.type.array.ArrayType;
import net.dericbourg.fuzzywallhack.generators.RootGenerator;

/**
 * Application entry point.
 */
public class FW {

	public static void main(String[] args) {

		// TODO Generator parameters.
		GenerationConfiguration cfg = new GenerationConfiguration();
		cfg.setFormatted(true);

		StructureType innerComplexData = PropertyTypeBuilder.structure()
				.addProperty(Property.of("inner", PropertyTypeBuilder.string().build()))
				.build();

		ArrayType simpleArray = PropertyTypeBuilder.array()
				.withInnerType(PropertyTypeBuilder.string().build())
				.withSize(5)
				.build();


		ArrayType complexArray = PropertyTypeBuilder.array()
				.withInnerType(PropertyTypeBuilder.structure()
								.addProperty(Property.of("val1", PropertyTypeBuilder.integer().build()))
								.addProperty(Property.of("val2", PropertyTypeBuilder.uuid().build()))
								.build()
				)
				.build();


		ObjectDescriptor objectDescriptor = Descriptor.object()
				.of(PropertyTypeBuilder.structure()
						.addProperty(Property.of("field1", PropertyTypeBuilder.string().build()))
						.addProperty(Property.of("field3", PropertyTypeBuilder.integer().build()))
						.addProperty(Property.of("field4", innerComplexData))
						.addProperty(Property.of("field5", simpleArray))
						.addProperty(Property.of("field6", complexArray))
						.addProperty(Property.of("field7", PropertyTypeBuilder.bool().build()))
						.build());

		RootGenerator rootGenerator = new RootGenerator();

		System.out.println("OBJECT");
		System.out.println(rootGenerator.generate(objectDescriptor));

		System.out.println();
		System.out.println("ARRAY");
		ArrayDescriptor arrayDescriptor = ObjectDescriptor.array().of(complexArray);
		System.out.println(rootGenerator.generate(arrayDescriptor));
	}
}
