/**
 * Creating a sidebar enables you to:
 - create an ordered group of docs
 - render a sidebar for each doc of that group
 - provide next/previous navigation

 The sidebars can be generated from the filesystem, or explicitly defined here.

 Create as many sidebars as you want.
 */

module.exports = {
	mySidebar: [
		{
			type: 'doc',
			id: 'home',
		},
		{
			type: 'category',
			label: 'Let\'s Study',
			items: [
				{
					type: 'category',
					label: '開発環境構築',
					items: [
						'development-setting/setting-manual',
					],
				},
				{
					type: 'category',
					label: 'Sample Code',
					items: [
						'sample-code/overview',
						'sample-code/spring-boot-setting',
						{
							type: 'category',
							label: 'REST API',
							items: [
								'sample-code/rest-api/overview',
								{
									type: 'category',
									label: '設計',
									items: [
										'sample-code/rest-api/design/overview',
										'sample-code/rest-api/design/input-output-document',
									],
								},
								'sample-code/rest-api/pg-documents',
								'sample-code/rest-api/test-documents',
							],
						},
					],
				},
				{
					type: 'category',
					label: 'GitHub関連',
					items: [
						{
							type: 'category',
							label: 'GIT',
							items: [
								'gitstudy/cmd-collection',
							],
						},
						{
							type: 'category',
							label: 'CI/CD',
							items: [
								'cicd/overview',
							],
						},
					],
				}
			],
		},
		{
			type: 'category',
			label: 'コンテンツ',
			items: [
				'content/introduction-docusaurus',
				'content/create-docusaurus',
			],
		},
	],
};
